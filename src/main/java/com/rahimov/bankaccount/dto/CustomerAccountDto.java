package com.rahimov.bankaccount.dto;

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
public class CustomerAccountDto {
    String id;
    BigDecimal balance;
    LocalDateTime creationDate;
    Set<AccountTransactionDto> transactions;
}
