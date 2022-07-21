package com.ironhack.accountservice.service.interfaces;

import com.ironhack.accountservice.model.Account;

public interface AccountService {
    Account createAccount(String industryString, int employeeCount, String city, String country);

    Account getAccountById(Long id);
}
