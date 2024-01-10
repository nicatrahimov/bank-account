package com.rahimov.bankaccount.service;

import com.rahimov.bankaccount.enums.TransactionType;
import com.rahimov.bankaccount.model.Account;
import com.rahimov.bankaccount.model.Transaction;
import com.rahimov.bankaccount.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final Logger logger = LoggerFactory.getLogger(TransactionService.class);


    protected Transaction initiateMoney(Account account, BigDecimal amount){
        return transactionRepository.save(
                Transaction.builder()
                        .amount(amount)
                        .transactionType(TransactionType.INITIAL)
                        .account(account)
                        .transactionDate(LocalDateTime.now())
                        .build()
        );
    }

}
