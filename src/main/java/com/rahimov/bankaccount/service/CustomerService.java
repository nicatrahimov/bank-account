package com.rahimov.bankaccount.service;

import com.rahimov.bankaccount.dto.converter.CustomerDtoConverter;
import com.rahimov.bankaccount.dto.request.CreateCustomerRequest;
import com.rahimov.bankaccount.dto.response.CustomerDto;
import com.rahimov.bankaccount.exception.CustomerNotFound;
import com.rahimov.bankaccount.model.Customer;
import com.rahimov.bankaccount.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    protected Customer findCustomerById(String id) {

        return
                customerRepository.findById(id).
                        orElseThrow(() -> new CustomerNotFound("Customer not found with id: " + id));

    }

    public ResponseEntity<String> createCustomer(CreateCustomerRequest request) {
        Customer c = Customer.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .build();
        customerRepository.save(c);
        return new
                ResponseEntity<>("succesfully added...", HttpStatusCode.valueOf(201));
    }


    public ResponseEntity<CustomerDto> getById(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFound("Customer not found"));

        return new
                ResponseEntity<>(converter.toCustomerDto(customer), HttpStatusCode.valueOf(200));
    }
}
