package com.technicaltest.restApi.controllers;

import com.technicaltest.restApi.dto.CreatePolicyDto;
import com.technicaltest.restApi.entity.Policy;
import com.technicaltest.restApi.service.PolicyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policy")
@CrossOrigin
public class PolicyController {
    @Autowired
    private PolicyService policyService;
    
    @GetMapping
    public List<Policy> list() {
        return policyService.list();
    }
    
    @PostMapping
    public /*Policy*/ CreatePolicyDto create(@RequestBody /*Policy policy*/CreatePolicyDto dto) {
        //return policyService.create(policy);
         //policyService.create(dto);
        return dto;
    }
    
    @PutMapping
    public Policy update(@RequestBody Policy policy) {
        return policyService.update(policy);
    }
    @DeleteMapping
    public void remove(@RequestBody Policy policy) {
        policyService.remove(policy);
    }
}
