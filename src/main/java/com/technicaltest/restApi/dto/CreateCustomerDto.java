package com.technicaltest.restApi.dto;

import javax.validation.constraints.NotBlank;
import com.technicaltest.restApi.entity.Customer;
import javax.validation.constraints.NotEmpty;

public class CreateCustomerDto {
    
   @NotEmpty(message="El nombre del cliente es requerido.")
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
   
   private Integer status;
   
   public Customer toCustomer() {
      Customer customer = new Customer();
      customer.setName(name);
      
      return customer;
   }
}
