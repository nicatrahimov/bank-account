package com.rahimov.bankaccount.repository;

import com.rahimov.bankaccount.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
