/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.restApi.service;

import com.technicaltest.restApi.entity.Customer;
import com.technicaltest.restApi.repository.CustomerRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
 
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    @PersistenceContext
    private EntityManager em;
    private static final Logger logger = LogManager.getLogger(Customer.class);
    public void create(Customer customer) {
       // return customerRepository.save(policy);
       /*
       List<Customer> customers = null;
       StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("sp_createCustomer")
               .setParameter("name", customer.getName());
       try {
          sp.execute();
          customers = sp.getResultList();
       } catch(Exception e) {
           logger.error("Ha ocurrido un error:",e);
       }      
       return customers;
*/    try {
        customerRepository.createCustomer(customer.getName());
      } catch(Exception e) {
          logger.error("Ha ocurrido un error:", e);
      }
    }
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
    public List<Customer> list() {
        return customerRepository.findAll();
    }
    public void remove(Customer customer) {
         customerRepository.delete(customer);
    }
}
