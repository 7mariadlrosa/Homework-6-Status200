package src.test.java.com.ironhack.accountservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.ironhack.accountservice.enums.Industry;
import com.ironhack.accountservice.model.Account;
import src.main.java.com.ironhack.accountservice.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerImplTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AccountRepository accountRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    Account account1, account2;

    @BeforeEach
    void setUp() {
        account1 = new Account(Industry.MEDICAL, 10,"Barcelona", "Spain");
        account2 = new Account(Industry.ECOMMERCE, 20,"Roma", "Italy");
        accountRepository.saveAll(List.of(account1,account2));
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
    }
}
