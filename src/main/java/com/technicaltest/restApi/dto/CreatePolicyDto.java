
package com.technicaltest.restApi.dto;

import java.util.ArrayList;
import java.util.List;

public class CreatePolicyDto {
    private CreateCustomerDto customer;
    private List<CreateVehicleDto> vehicles = new ArrayList<>();  

    public CreateCustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CreateCustomerDto customer) {
        this.customer = customer;
    }

    public List<CreateVehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<CreateVehicleDto> vehicles) {
        this.vehicles = vehicles;
    }
    
}
