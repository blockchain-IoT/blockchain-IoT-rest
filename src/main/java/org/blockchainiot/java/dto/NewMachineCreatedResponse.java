package org.blockchainiot.java.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

final public class NewMachineCreatedResponse {


    @NonNull
    private final String contractAddress;


    @JsonCreator
    public NewMachineCreatedResponse(@NonNull @JsonProperty("contractAddress") String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewMachineCreatedResponse that = (NewMachineCreatedResponse) o;

        return contractAddress != null ? contractAddress.equals(that.contractAddress) : that.contractAddress == null;
    }

    @Override
    public int hashCode() {
        return contractAddress != null ? contractAddress.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NewMachineCreatedResponse{" +
                "contractAddress='" + contractAddress + '\'' +
                '}';
    }
}