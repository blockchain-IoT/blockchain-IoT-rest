package org.blockchainiot.java;


import org.blockchainiot.java.dto.AccountUnlockRequest;
import org.blockchainiot.java.dto.NewMachineCreatedResponse;
import org.blockchainiot.java.dto.NewMachineRequest;
import org.blockchainiot.java.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.List;


@RestController
public class AdminController {


    private final Admin admin;

    private final MachineService machineService;


    @Autowired
    public AdminController(Admin admin, MachineService machineService) {
        this.admin = admin;
        this.machineService = machineService;
    }


    @GetMapping("/version")
    public Mono<Web3ClientVersion> getVersion() {
        return
                Mono.fromCompletionStage
                        (admin
                                .web3ClientVersion()
                                .sendAsync()
                        );
    }

    @GetMapping(value = "/machine/{contractAddress}/rentalcount", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<BigInteger> createNewMachine(@RequestHeader("fromAddress") @NonNull String fromAddress,
                                             @PathVariable("contractAddress") @NonNull String contractAddress) {
        return machineService
                .rentalCount(fromAddress, contractAddress);

    }

    @PostMapping(value = "/machine", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<NewMachineCreatedResponse> createNewMachine(@RequestBody @NonNull NewMachineRequest request) {
        return machineService
                .addMachine(
                        request.getOwnerAddress(),
                        request.getModel(),
                        request.getMake(),
                        request.getVin()
                )
                .map(machine -> new NewMachineCreatedResponse(machine.getContractAddress()));
    }


    @PostMapping("/account")
    public Mono<PersonalUnlockAccount> unlockAccount(@RequestBody @NonNull AccountUnlockRequest request) {
        return Mono.fromCompletionStage
                (
                    admin
                        .personalUnlockAccount(request.getAddress(), request.getPassPhrase())
                        .sendAsync()
                );
    }


    @GetMapping("/{address}/balance")
    public Mono<EthGetBalance> getBalance(@PathVariable("address") @NonNull String address) {
        return
                Mono.fromCompletionStage
                        (admin
                                .ethGetBalance(address, DefaultBlockParameterName.LATEST)
                                .sendAsync()
                );
    }

    @GetMapping("/account")
    public Mono<ResponseEntity<List<String>>> getAccounts() {
        return
                Mono.fromCompletionStage(
                        admin
                                .ethAccounts()
                                .sendAsync()
                )
                .map(ethAccounts -> ResponseEntity.ok(ethAccounts.getAccounts()));

    }
}