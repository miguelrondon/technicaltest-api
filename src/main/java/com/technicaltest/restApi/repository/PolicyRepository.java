package com.technicaltest.restApi.repository;

import com.technicaltest.restApi.entity.Policy;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call sp_createPolicy(:name, :brand, :model, :year, :vinNumber, :plateNumber)")
    void createPolicy(
            @Param("name") String name,
            @Param("brand") String brand, 
            @Param("model") String model,
            @Param("year") Integer year,
            @Param("vinNumber") String vinNumber,
            @Param("plateNumber") String plateNumber
           );
}
