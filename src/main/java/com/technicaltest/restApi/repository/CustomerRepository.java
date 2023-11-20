package com.technicaltest.restApi.repository;

import com.technicaltest.restApi.entity.Customer;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
//    @Procedure(procedureName = "sp_createCustomer")
//    Customer createCustomer(String name);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call sp_createCustomer(:name)")
    void createCustomer(@Param("name") String name);
}
