package com.ironhack.opportunityservice.repository;

import com.ironhack.opportunityservice.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

}
