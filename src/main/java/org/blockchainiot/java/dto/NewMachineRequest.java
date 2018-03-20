package org.blockchainiot.java.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

final public class NewMachineRequest {


    @NonNull
    private final String ownerAddress;

    @NonNull
    private final String model;

    @NonNull
    private final String make;

    @NonNull
    private final String vin;


    @JsonCreator
    public NewMachineRequest(@NonNull @JsonProperty("ownerAddress") String ownerAddress,
                             @NonNull @JsonProperty("model") String model,
                             @NonNull @JsonProperty("make") String make,
                             @NonNull @JsonProperty("vin") String vin) {
        this.ownerAddress = ownerAddress;
        this.model = model;
        this.make = make;
        this.vin = vin;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewMachineRequest that = (NewMachineRequest) o;

        if (ownerAddress != null ? !ownerAddress.equals(that.ownerAddress) : that.ownerAddress != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (make != null ? !make.equals(that.make) : that.make != null) return false;
        return vin != null ? vin.equals(that.vin) : that.vin == null;
    }

    @Override
    public int hashCode() {
        int result = ownerAddress != null ? ownerAddress.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (vin != null ? vin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewMachineRequest{" +
                "ownerAddress='" + ownerAddress + '\'' +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}