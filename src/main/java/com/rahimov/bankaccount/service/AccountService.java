package com.rahimov.bankaccount.service;

import com.rahimov.bankaccount.dto.response.AccountDto;
import com.rahimov.bankaccount.dto.request.CreateAccountRequest;
import com.rahimov.bankaccount.dto.converter.AccountDtoConverter;
import com.rahimov.bankaccount.model.Account;
import com.rahimov.bankaccount.model.Customer;
import com.rahimov.bankaccount.model.Transaction;
import com.rahimov.bankaccount.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final  TransactionService transactionService;
    private final AccountDtoConverter converter;


    public AccountDto createAccount(CreateAccountRequest request){

        Customer customer = customerService.findCustomerById(request.getCustomerId());
        Account account = Account.builder().balance(request.getInitialCredit())
                .creationDate(LocalDateTime.now())
                .customer(customer)
                .transactions(new HashSet<>())
                .build();

            if (request.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
                Transaction transaction = transactionService.initiateMoney(account,request.getInitialCredit());
                account.getTransactions().add(transaction);
            }
            return converter.toAccountDto(accountRepository.save(account));
    }
}
