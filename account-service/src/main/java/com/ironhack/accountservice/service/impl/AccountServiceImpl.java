package src.main.java.com.ironhack.accountservice.service.impl;

import com.ironhack.accountservice.enums.Industry;
import com.ironhack.accountservice.model.Account;
import com.ironhack.accountservice.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import src.main.java.com.ironhack.accountservice.repository.AccountRepository;


@Service
public abstract class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

//EL FINFBYID ME DABA ERROR
   /* public Account getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
        return account;
    }*/


    public Account createAccount(String industryString, int employeeCount, String city, String country) {
        Industry industryEnum;
        try{
            industryEnum = Industry.valueOf(industryString.toUpperCase());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Should be: PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER");
        }
        Account account = new Account(industryEnum,employeeCount,city,country);
        return accountRepository.save(account);
    }
}
