package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.controller.dto.StatusDTO;
import com.ironhack.edgeservice.model.Opportunity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("opportunity-service")
public interface OpportunityClient {

    @GetMapping("/opportunities")
    List<Opportunity> getAllOpportunities();

    @GetMapping("/opportunities/{id}")
    Opportunity getOpportunityById(@PathVariable Long id);

    @GetMapping("/opportunity-products")
    List<Object[]> getAllOpportunitiesByProduct();

    @GetMapping("/opportunity-sales-rep")
    List <Object[]> getOpportunitiesBySalesRep();
    @GetMapping("/opportunity-sales-rep/closed-won")
    List <Object[]> getOpportunitiesClosedWonBySalesRep();

    @PostMapping("/opportunities")
    Opportunity createOpportunity(@RequestBody OpportunityDTO opportunityDto);

}
