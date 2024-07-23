package com.example.testinterview.service;

import com.example.testinterview.domain.Account;

import java.util.List;

public interface AccountsService {

    List<Account> findAccountsByBeneficiaryId(Long id);
}
