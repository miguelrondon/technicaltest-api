package com.technicaltest.restApi.controllers;

import com.technicaltest.restApi.entity.Customer;
import com.technicaltest.restApi.dto.CreateCustomerDto;
import com.technicaltest.restApi.service.CustomerService;
import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
   // private static final Logger logger = LoggerContextFactorytFactory.getLogger(Customer.class);
    private static final Logger logger = LogManager.getLogger(Customer.class);
    @GetMapping
    public List<Customer> list() {
        return customerService.list();
    }
    
    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody CreateCustomerDto customerDto) {
        customerService.create(customerDto.toCustomer());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }
    @DeleteMapping
    public void remove(@RequestBody Customer customer) {
        customerService.remove(customer);
    }
}
