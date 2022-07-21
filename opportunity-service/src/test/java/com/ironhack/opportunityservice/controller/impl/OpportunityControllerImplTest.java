package com.ironhack.opportunityservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.opportunityservice.enums.Product;
import com.ironhack.opportunityservice.enums.Status;
import com.ironhack.opportunityservice.model.Opportunity;
import com.ironhack.opportunityservice.repository.OpportunityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OpportunityControllerImplTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OpportunityRepository opportunityRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    Opportunity opportunity1, opportunity2,opportunity3;

    @BeforeEach
    void setUp() {
        opportunity1 = new Opportunity(Product.FLATBED,10,1L,1L,1L);
        opportunity2 = new Opportunity(Product.FLATBED,20,1L,1L,2L);
        opportunity3 = new Opportunity(Product.BOX,10,1L,2L,3L);
        opportunity3.setStatus(Status.CLOSED_LOST);     //NO LO TENGO MUY CLARO

        opportunityRepository.saveAll(List.of(opportunity1,opportunity2,opportunity3));
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void getAllOpportunities() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opportunities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("FLATBED"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("10"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("FLATBED"));
    }

    @Test
    void getOpportunityById_CorrectId_Opportunity() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/opportunities/"+opportunity1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON); //ME DA FALLO
        assertTrue(mvcResult.getResponse().getContentAsString().contains("FLATBED"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("FLATBED"));
    }

}