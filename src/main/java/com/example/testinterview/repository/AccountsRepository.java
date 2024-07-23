package com.example.testinterview.repository;

import com.example.testinterview.domain.Account;

import java.util.List;

public interface AccountsRepository {

    List<Account> findAccountsByBeneficiaryId(Long beneficiaryId);
}
