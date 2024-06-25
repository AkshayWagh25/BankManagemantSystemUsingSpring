package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class BankAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountManagementApplication.class, args);
	}

}
