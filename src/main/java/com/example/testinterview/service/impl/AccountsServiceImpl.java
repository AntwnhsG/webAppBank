package com.example.testinterview.service.impl;

import com.example.testinterview.domain.Account;
import com.example.testinterview.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    @Override
    public List<Account> findAccountsByBeneficiaryId(Long id) {

        return null;
    }
}
