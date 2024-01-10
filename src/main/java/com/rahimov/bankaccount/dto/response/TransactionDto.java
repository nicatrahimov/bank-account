package com.rahimov.bankaccount.dto.response;

import com.rahimov.bankaccount.enums.TransactionType;
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
public class TransactionDto {
    String id;
    TransactionType transactionType;
    BigDecimal amount;
    LocalDateTime transactionDate;
    TransactionAccountDto account;
}
