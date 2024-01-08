package com.rahimov.bankaccount.dto;

import com.rahimov.bankaccount.model.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    String id;
    String name;
    String surname;
    Set<CustomerAccountDto> accounts;
}
