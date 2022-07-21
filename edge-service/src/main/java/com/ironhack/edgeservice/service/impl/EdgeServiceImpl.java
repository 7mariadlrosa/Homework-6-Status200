package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.*;
import com.ironhack.edgeservice.controller.dto.AccountDTO;
import com.ironhack.edgeservice.controller.dto.ConvertDTO;
import com.ironhack.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.edgeservice.model.Account;
import com.ironhack.edgeservice.model.Lead;
import com.ironhack.edgeservice.model.Opportunity;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    private AccountClient accountClient;
    @Autowired
    private LeadClient leadClient;

    @Autowired
    private SalesRepClient salesRepClient;
    @Autowired
    private OpportunityClient opportunityClient;

    @Override
    public String convertLead(Long id, ConvertDTO convertDTO) {
        return null;
    }

   /* @CircuitBreaker(name = "convert")
    public String convertLead(Long id, ConvertDTO convertDTO){
        Lead lead = leadClient.getLeadById(id);
        Account account;
        if (convertDTO.getAccountId() != null){
            account = accountClient.getAccountById(convertDTO.getAccountId());
        } else {
            AccountDTO accountDTO = new AccountDTO(convertDTO.getIndustry(),convertDTO.getEmployeeCount(),
                    convertDTO.getCity(),convertDTO.getCountry());
            account = accountClient.createAccount(accountDTO);
        }

        OpportunityDTO opportunityDTO = new OpportunityDTO(convertDTO.getProduct(), convertDTO.getQuantity(),account.getId(), lead.getSalesRepId());
        Opportunity opportunity = opportunityClient.createOpportunity(opportunityDTO);
        return id;
        LO TENGO COMENTADO PORQUE ME ESTABA DANDO FALLO*/
    }

}