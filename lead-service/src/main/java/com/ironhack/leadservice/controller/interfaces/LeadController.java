package com.ironhack.leadservice.controller.interfaces;

import com.ironhack.leadservice.model.Lead;

import java.util.List;

public interface LeadController {
    List<Lead> getAllLead();
    Lead getLeadById(Long id);
    Lead postLead(Lead lead);

    void delete(Long id);
}