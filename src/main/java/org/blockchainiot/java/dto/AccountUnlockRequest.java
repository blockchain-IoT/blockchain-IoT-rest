package org.blockchainiot.java.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

final public class AccountUnlockRequest {


    private final String address;

    private final String passPhrase;


    @JsonCreator
    public AccountUnlockRequest(@JsonProperty("address") String address, @JsonProperty("passphrase") String passPhrase) {
        this.address = address;
        this.passPhrase = passPhrase;
    }

    public String getAddress() {
        return address;
    }

    public String getPassPhrase() {
        return passPhrase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountUnlockRequest that = (AccountUnlockRequest) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return passPhrase != null ? passPhrase.equals(that.passPhrase) : that.passPhrase == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (passPhrase != null ? passPhrase.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountUnlockRequest{" +
                "address='" + address + '\'' +
                ", passPhrase='" + passPhrase + '\'' +
                '}';
    }
}