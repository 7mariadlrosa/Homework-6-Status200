package com.ironhack.opportunityservice.controller.impl;

import com.ironhack.opportunityservice.controller.dto.OpportunityDTO;
import com.ironhack.opportunityservice.controller.dto.StatusDTO;
import com.ironhack.opportunityservice.controller.interfaces.OpportunityController;
import com.ironhack.opportunityservice.enums.Product;
import com.ironhack.opportunityservice.model.Opportunity;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import com.ironhack.opportunityservice.service.interfaces.OpportunityService;
import com.ironhack.opportunityservice.enums.Status;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class OpportunityControllerImpl implements OpportunityController {


    @Autowired
    private OpportunityService opportunityService;
    @Autowired
    private OpportunityRepository opportunityRepository;

    @GetMapping("/opportunities")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    @GetMapping("/opportunities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity getOpportunityById(@PathVariable Long id) {

        return opportunityService.getOpportunityById(id);
    }

    @GetMapping("/opportunity-products")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getAllOpportunitiesByProduct(){
        return opportunityRepository.findOpportunitiesByProduct();
    }

    @PostMapping("/opportunities")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity createOpportunity(@RequestBody OpportunityDTO opportunityDto) {
        String product = opportunityDto.getProduct();
        int quantity = opportunityDto.getQuantity();
        Long decisionMakerId = opportunityDto.getDecisionMakerId();
        Long accountId = opportunityDto.getAccountId();
        Long salesRepId = opportunityDto.getSalesRepId();

        return opportunityService.createOpportunity(product, quantity,
                decisionMakerId, accountId, salesRepId);
    }

}
