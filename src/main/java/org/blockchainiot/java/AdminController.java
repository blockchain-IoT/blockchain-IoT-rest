package org.blockchainiot.java;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
public class AdminController {


    private final Web3j web3j;


    @Autowired
    public AdminController(Web3j web3j) {
        this.web3j = web3j;
    }


    @GetMapping("/version")
    public Mono<Web3ClientVersion> getVersion() {
        return
                Mono.fromCompletionStage
                        (web3j
                                .web3ClientVersion()
                                .sendAsync()
                        );
    }


    @GetMapping("/{address}/balance")
    public Mono<EthGetBalance> getBalance(@PathVariable("address") String address) {
        return
                Mono.fromCompletionStage
                        (web3j
                                .ethGetBalance(address, DefaultBlockParameterName.LATEST)
                                .sendAsync()
                );
    }

    @GetMapping("/account")
    public Mono<ResponseEntity<List<String>>> getAccounts() {
        return
                Mono.fromCompletionStage(
                        web3j
                                .ethAccounts()
                                .sendAsync()
                )
                .map(ethAccounts -> ResponseEntity.ok(ethAccounts.getAccounts()));

    }


}