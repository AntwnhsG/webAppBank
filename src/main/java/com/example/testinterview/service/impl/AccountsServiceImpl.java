package com.example.testinterview.service.impl;

import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Beneficiary;
import com.example.testinterview.repository.AccountsRepository;
import com.example.testinterview.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    @Override
    public List<Account> findAccountsByBeneficiaryId(Long beneficiaryId) { return accountsRepository.findAccountsByBeneficiaryId(beneficiaryId); }
}
