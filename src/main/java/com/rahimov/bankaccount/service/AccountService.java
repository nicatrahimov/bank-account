package com.rahimov.bankaccount.service;

import com.rahimov.bankaccount.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
}
