package com.example.testinterview.repository.impl;

import com.example.testinterview.domain.Account;
import com.example.testinterview.repository.AccountsRepository;

import java.util.List;

public class AccountsRepositoryImpl implements AccountsRepository {
    @Override
    public List<Account> findAccountsByBeneficiaryId(Long beneficiaryId) {
        //TODO: Implement functionality to read from csv
        return List.of();
    }
}
