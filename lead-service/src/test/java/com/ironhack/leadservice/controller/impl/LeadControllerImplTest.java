package com.ironhack.leadservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.leadservice.model.Lead;
import com.ironhack.leadservice.repository.LeadRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class LeadControllerImplTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LeadRepository leadRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    Lead lead1, lead2;

    @BeforeEach
    void setUp() {
        lead1 = new Lead("Sheri","671194671","s@gmail.com",
                "123456",1L);
        lead2 = new Lead("Maria","659453456","m@gmail.com",
                "123456",2L);
        leadRepository.saveAll(List.of(lead1,lead2));
    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
    }

    @Test
    void getAllLeads() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/leads"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Sheri"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Maria"));
    }

}