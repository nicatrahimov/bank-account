package com.rahimov.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionAccountDto {
    String id;
    BigDecimal balance;
    LocalDateTime creationDate;
    AccountCustomerDto customer;
}
