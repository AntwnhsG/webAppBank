package com.example.testinterview.service;

import com.example.testinterview.domain.Account;

public interface AccountsService {

    Account findAccountsByBeneficiaryId(Long id);
}
