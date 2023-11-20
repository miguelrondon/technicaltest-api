/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.restApi.service;

import com.technicaltest.restApi.dto.CreatePolicyDto;
import com.technicaltest.restApi.dto.CreateVehicleDto;
import com.technicaltest.restApi.entity.Policy;
import com.technicaltest.restApi.repository.PolicyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {
 
    @Autowired
    private PolicyRepository policyRepository;
    
    public Policy create(Policy policy) {
        return policyRepository.save(policy);
    }
    public CreatePolicyDto create(CreatePolicyDto policy) {
//        return policyRepository.createPolicy(
//                policy.getCustomer().getName(),
//                policy.getVehicles().ge
//        );
        for(CreateVehicleDto vehicle: policy.getVehicles()) {
            policyRepository.createPolicy(policy.getCustomer().getName(),
                    vehicle.getBrand(), vehicle.getModel(), vehicle.getYear(), vehicle.getVinNumber(), vehicle.getPlateNumber());
        }
        return null;
    }
    public Policy update(Policy policy) {
        return policyRepository.save(policy);
    }
    public List<Policy> list() {
        return policyRepository.findAll();
    }
    public void remove(Policy policy) {
         policyRepository.delete(policy);
    }
}
