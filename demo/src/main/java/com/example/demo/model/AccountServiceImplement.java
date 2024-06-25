package com.example.demo.model;

import com.example.demo.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplement  implements  AccountService{

    @Autowired
    AccRepo repo;


    @Override
    public Account createAccount(Account account) {
        Account acc_saved = repo.save(account);
        return acc_saved;

    }

    @Override
    public Account getAccountDetailsByAcNumber(long AccountNumber) {
        Optional<Account>account = repo.findById(AccountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        else{
            Account account_found = account.get();
            return account_found;
        }
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account>accountList = repo.findAll();
        return accountList;
    }

    @Override
    public Account depositeAmount(Long accountNumber, Double amount) {
        Optional<Account>account = repo.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("account Not Present");
        }
        Account accountPresent = account.get();
        double totalBalance = accountPresent.getAccount_balance()+amount;
        accountPresent.setAccount_balance(totalBalance);
        repo.save(accountPresent);
        return accountPresent;

    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Optional<Account>account = repo.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("account not present");
        }
        Account accountPresent = account.get();
        double totalBalance = accountPresent.getAccount_balance()-amount;
        accountPresent.setAccount_balance(totalBalance);
        repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        getAccountDetailsByAcNumber(accountNumber);
        repo.deleteById(accountNumber);

    }
}
