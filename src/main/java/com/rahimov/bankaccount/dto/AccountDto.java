package com.rahimov.bankaccount.dto;

import com.rahimov.bankaccount.model.Customer;
import com.rahimov.bankaccount.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    String id;
    BigDecimal balance;
    LocalDateTime creationDate;
    AccountCustomerDto customer;
    Set<TransactionDto> transactions;
}
