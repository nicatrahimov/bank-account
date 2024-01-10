package com.rahimov.bankaccount.dto.converter;

import com.rahimov.bankaccount.dto.response.AccountCustomerDto;
import com.rahimov.bankaccount.dto.response.CustomerDto;
import com.rahimov.bankaccount.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerDtoConverter {
    private final CustomerAccountDtoConverter converter;

    protected AccountCustomerDto toAccountCustomer(Customer customer){
        return new AccountCustomerDto(customer.getId(),
                customer.getName(),
                customer.getSurname());
    }

    public CustomerDto toCustomerDto(Customer customer){
        return new CustomerDto(customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAccounts().stream()
                        .map(converter::toCustomerAccount)
                        .collect(Collectors.toSet())
        );
    }
}
