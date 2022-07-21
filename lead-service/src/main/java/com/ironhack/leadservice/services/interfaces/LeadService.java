package com.ironhack.leadservice.services.interfaces;

import com.ironhack.leadservice.model.Lead;

public interface LeadService {
    Lead getLeadById(Long id);

    void delete(Long id);
}
