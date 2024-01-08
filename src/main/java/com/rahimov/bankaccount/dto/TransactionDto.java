package com.rahimov.bankaccount.dto;

import com.rahimov.bankaccount.enums.TransactionType;
import com.rahimov.bankaccount.model.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

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
    Account account;
}
