package com.rahimov.bankaccount.dto.converter;

import com.rahimov.bankaccount.dto.response.CustomerAccountDto;
import com.rahimov.bankaccount.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class CustomerAccountDtoConverter {
    private final TransactionDtoConverter converter;

    protected CustomerAccountDto toCustomerAccount(Account account) {
        return new CustomerAccountDto(account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                account.getTransactions().stream()
                        .map(converter::toAccountTransactionDto)
                        .collect(Collectors.toSet())
        );
    }
}
