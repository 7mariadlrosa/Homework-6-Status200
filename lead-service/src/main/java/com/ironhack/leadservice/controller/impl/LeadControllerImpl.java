package com.ironhack.leadservice.controller.impl;

import com.ironhack.leadservice.controller.interfaces.LeadController;
import com.ironhack.leadservice.model.Lead;
import com.ironhack.leadservice.repository.LeadRepository;
import com.ironhack.leadservice.services.interfaces.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeadControllerImpl implements LeadController {

    @Autowired
    private LeadService leadService;
    @Autowired
    private LeadRepository leadRepository;


    @GetMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public List<Lead> getAllLead() {
        return leadRepository.findAll();
    }

    @GetMapping("/leads/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lead getLeadById(@PathVariable Long id) {
        return leadService.getLeadById(id);
    }

    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public Lead postLead(@RequestBody Lead lead){
        return leadRepository.save(lead);
    }

    @DeleteMapping("/leads/{id}")
    public void delete(@PathVariable Long id) {
        leadService.delete(id);
    }
}
