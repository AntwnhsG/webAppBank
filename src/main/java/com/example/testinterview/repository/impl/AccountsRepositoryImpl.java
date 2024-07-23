package com.example.testinterview.repository.impl;

import com.example.testinterview.domain.Account;
import com.example.testinterview.repository.AccountsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountsRepositoryImpl implements AccountsRepository {

    @Override
    public List<Account> findAccountsByBeneficiaryId(Long beneficiaryId) {
        //TODO: Implement functionality to read from csv
        return List.of();
    }
}
