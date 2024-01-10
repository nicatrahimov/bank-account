package com.rahimov.bankaccount.dto.converter;

import com.rahimov.bankaccount.dto.response.AccountTransactionDto;
import com.rahimov.bankaccount.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionDtoConverter {
    protected AccountTransactionDto toAccountTransactionDto (Transaction transaction){
        return new AccountTransactionDto(transaction.getId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionDate());
    }
}
