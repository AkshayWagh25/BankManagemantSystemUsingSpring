package com.example.demo.model;

import com.example.demo.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService {

    public Account createAccount(Account account);
    public Account getAccountDetailsByAcNumber(long AccountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositeAmount(Long accountNumber , Double amount);
    public Account withdrawAmount(Long accountNumber ,  Double amount);
    public void closeAccount(Long accountNumber);

}
