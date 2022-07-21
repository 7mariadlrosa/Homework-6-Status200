package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.client.*;
import com.ironhack.edgeservice.controller.dto.AccountDTO;
import com.ironhack.edgeservice.controller.dto.ConvertDTO;
import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.controller.dto.StatusDTO;
import com.ironhack.edgeservice.controller.interfaces.EdgeController;
import com.ironhack.edgeservice.enums.Status;
import com.ironhack.edgeservice.model.*;
import com.ironhack.edgeservice.repository.EdgeRepository;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EdgeControllerImpl implements EdgeController {

    @Autowired
    private OpportunityClient opportunityClient;

    @Autowired
    private AccountClient accountClient;
    @Autowired
    private LeadClient leadClient;

    @Autowired
    private SalesRepClient salesRepClient;

    @Autowired
    private EdgeRepository edgeRepository;

    @Autowired
    private EdgeService edgeService;

    @GetMapping("/opportunities")
    @ResponseStatus(HttpStatus.OK)
    public List<Opportunity> getAllOpportunities(){
        return opportunityClient.getAllOpportunities();
    }

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts(){
        return accountClient.getAllAccount();
    }

    @GetMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public List<Lead> getAllLeads(){
        return leadClient.getAllLead();
    }

    @GetMapping("/sales-rep")
    @ResponseStatus(HttpStatus.OK)
    public List<SalesRep> getAllSalesRep() {
        return salesRepClient.getAllSalesRep();
    }


    @GetMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lead getLeadsById(@PathVariable Long id){
        return leadClient.getLeadById(id);
    }

    @GetMapping("/sales-rep/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesRep getSalesRepsById(@PathVariable Long id) {
        return salesRepClient.getSalesRepById(id);
    }


    @GetMapping("/opportunities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity getOpportunitiesById(@PathVariable Long id){
        return opportunityClient.getOpportunityById(id);
    }

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountsById(@PathVariable Long id){
        return accountClient.getAccountById(id);
    }

    @GetMapping("/opportunity-products")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> getAllOpportunitiesByProduct(){
        return opportunityClient.getAllOpportunitiesByProduct();
    }


    @GetMapping("/opportunity-sales-rep")
    @ResponseStatus(HttpStatus.OK)
    public List <Object[]> getOpportunitiesBySalesRep(){
        return opportunityClient.getOpportunitiesBySalesRep();
    };

}
