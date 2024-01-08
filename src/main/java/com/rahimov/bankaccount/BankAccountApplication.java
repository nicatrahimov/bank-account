package com.rahimov.bankaccount;

import com.rahimov.bankaccount.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class BankAccountApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
Account a = new Account("1", BigDecimal.ONE, LocalDateTime.now(),null,null);
Account b = new Account("2", BigDecimal.ONE, LocalDateTime.now(),null,null);
	}
}
