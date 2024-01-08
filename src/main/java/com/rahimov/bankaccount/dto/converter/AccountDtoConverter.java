package com.rahimov.bankaccount.dto.converter;

import com.rahimov.bankaccount.dto.AccountDto;
import com.rahimov.bankaccount.dto.CustomerAccountDto;
import com.rahimov.bankaccount.dto.TransactionAccountDto;
import com.rahimov.bankaccount.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDto toAccountDto(Account account) {

        return new AccountDto(account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                customerDtoConverter.toAccountCustomer(account.getCustomer()),
                account.getTransactions().stream()
                        .map(transactionDtoConverter::toAccountTransactionDto)
                        .collect(Collectors.toSet())
        );
    }
    public TransactionAccountDto toTransactionAccountDto(Account account) {
        return new TransactionAccountDto(account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                customerDtoConverter.toAccountCustomer(account.getCustomer())
        );
    }
    public CustomerAccountDto toCustomerAccount(Account account) {
        return new CustomerAccountDto(account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                account.getTransactions().stream()
                        .map(transactionDtoConverter::toAccountTransactionDto)
                        .collect(Collectors.toSet())
        );
    }



}
