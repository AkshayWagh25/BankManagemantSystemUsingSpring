package com.example.demo.model;

import com.example.demo.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class bankController {

    @Autowired
    AccountService service;
    // crate account
    @PostMapping("/createBankAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account createAccount = service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

    @GetMapping("/getAccount/{accountNumber}")
    public Account getAccountOfParticularId(@PathVariable Long accountNumber){
        Account account = service.getAccountDetailsByAcNumber(accountNumber);
        return account;
    }

    @GetMapping("/getAllAccount")
    public List<Account>getAllAccountDetails(){
        List<Account>accountList = service.getAllAccountDetails();
        return accountList;
    }
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositMoneyInParticularAccount(@PathVariable Long accountNumber , @PathVariable Double amount){
        Account account = service.depositeAmount(accountNumber , amount);
        return account ;

    }
    @PutMapping("withdrawMoney/{accountNumber}/{amount}")
    public Account withdrawMoneyFromParticularAccount(@PathVariable Long accountNumber , @PathVariable Double amount){
        Account account = service.withdrawAmount(accountNumber,amount);
        return account;
    }
    @DeleteMapping("deleteAccount/{accountNumber}")

    public ResponseEntity<String> deleteparticularAccount(@PathVariable Long accountNumber){
      service.closeAccount(accountNumber);
      return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");


    }
}
