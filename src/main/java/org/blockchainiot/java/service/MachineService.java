package org.blockchainiot.java.service;


import org.blockchainiot.java.contract.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.web3j.protocol.admin.Admin;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.nio.charset.Charset;

@Service
public class MachineService {


    private final BigInteger GAS_PRICE = new BigInteger("20000000000");

    private final Admin admin;


    @Autowired
    public MachineService(Admin admin) {
        this.admin = admin;

    }


    public Mono<Machine> addMachine(@NonNull String fromAddress, @NonNull String model, @NonNull String make, @NonNull String vin) {
        final TransactionManager clientTransactionManager = new ClientTransactionManager(admin, fromAddress);

        return Mono.fromCompletionStage(
            Machine
                    .deploy(
                        admin,
                        clientTransactionManager,
                        GAS_PRICE,
                        Contract.GAS_LIMIT,
                        model,
                        make,
                        vin.getBytes(Charset.forName("UTF8"))
                    )
                    .sendAsync()
        );
    }

    public Mono<BigInteger> rentalCount(@NonNull String fromAddress, @NonNull String machineAddress) {
        final TransactionManager clientTransactionManager = new ClientTransactionManager(admin, fromAddress);

        return Mono.fromCompletionStage(
                Machine
                        .load(
                              machineAddress,
                              admin,
                              clientTransactionManager,
                              GAS_PRICE,
                              Contract.GAS_LIMIT
                        )
                        .rentalCount()
                        .sendAsync()
        );

    }
}
