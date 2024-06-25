package com.example.demo.model;

import com.example.demo.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccRepo extends JpaRepository<Account, Long> {

}
