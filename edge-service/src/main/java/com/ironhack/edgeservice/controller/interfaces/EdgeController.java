package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.ConvertDTO;
import com.ironhack.edgeservice.controller.dto.StatusDTO;
import com.ironhack.edgeservice.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EdgeController {

    Opportunity getOpportunitiesById( Long id);
    List<Object[]> getAllOpportunitiesByProduct();

    List <Object[]> getOpportunitiesBySalesRep();

    Account getAccountsById(Long id);
    List<Lead> getAllLeads();
    List<SalesRep> getAllSalesRep();
    List<Opportunity> getAllOpportunities();
    List<Account> getAllAccounts();
    Lead getLeadsById(Long id);
    SalesRep getSalesRepsById(Long id);

}
