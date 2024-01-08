package com.rahimov.bankaccount.dto.converter;

import com.rahimov.bankaccount.dto.AccountTransactionDto;
import com.rahimov.bankaccount.dto.TransactionDto;
import com.rahimov.bankaccount.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionDtoConverter {
    private final AccountDtoConverter accountDtoConverter;

    public AccountTransactionDto toAccountTransactionDto (Transaction transaction){
        return new AccountTransactionDto(transaction.getId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionDate());
    }
    public TransactionDto toTransactionDto (Transaction transaction){
        return new TransactionDto(transaction.getId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionDate(),
                accountDtoConverter.toTransactionAccountDto(transaction.getAccount())
                );
    }

}
