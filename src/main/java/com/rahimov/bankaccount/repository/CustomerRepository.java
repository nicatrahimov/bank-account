package com.rahimov.bankaccount.repository;

import com.rahimov.bankaccount.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
