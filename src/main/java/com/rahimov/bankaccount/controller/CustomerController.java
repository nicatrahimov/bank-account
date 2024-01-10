package com.rahimov.bankaccount.controller;

import com.rahimov.bankaccount.dto.request.CreateCustomerRequest;
import com.rahimov.bankaccount.dto.response.CustomerDto;
import com.rahimov.bankaccount.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody CreateCustomerRequest request){
        return customerService.createCustomer(request);
    }
@GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id){
        return customerService.getById(id);
}
}
