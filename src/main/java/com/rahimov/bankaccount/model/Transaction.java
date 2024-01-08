package com.rahimov.bankaccount.model;

import com.rahimov.bankaccount.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Enumerated(EnumType.STRING)
    @Value("${com.rahimov.bankaccount.enums.TransactionType:TransactionType.INITIAL}")
    TransactionType transactionType;

    BigDecimal amount;
    LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",nullable = false)
    Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return Objects.equals(getId(), that.getId()) && getTransactionType() == that.getTransactionType() && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getTransactionDate(), that.getTransactionDate()) && Objects.equals(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTransactionType(), getAmount(), getTransactionDate());
    }
}
