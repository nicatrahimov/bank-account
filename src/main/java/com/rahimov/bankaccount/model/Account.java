package com.rahimov.bankaccount.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    BigDecimal balance;
    LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false)
    Customer customer;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    Set<Transaction> transactions;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(getId(), account.getId()) && Objects.equals(getBalance(), account.getBalance()) && Objects.equals(getCreationDate(), account.getCreationDate()) && Objects.equals(getCustomer(), account.getCustomer()) && Objects.equals(getTransactions(), account.getTransactions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance(), getCreationDate());
    }
}


