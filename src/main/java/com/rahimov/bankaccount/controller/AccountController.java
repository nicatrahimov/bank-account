package com.rahimov.bankaccount.controller;

import com.rahimov.bankaccount.dto.response.AccountDto;
import com.rahimov.bankaccount.dto.request.CreateAccountRequest;
import com.rahimov.bankaccount.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountDto createAccount(@RequestBody CreateAccountRequest request){

    return accountService.createAccount(request);
    }

}
