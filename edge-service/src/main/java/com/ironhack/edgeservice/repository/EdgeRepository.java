package com.ironhack.edgeservice.repository;

import com.ironhack.edgeservice.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

//NO ENTIENDO POR QUÉ DA FALLO EN TODAS :(
public interface EdgeRepository extends JpaRepository<Opportunity, Long> {

}
