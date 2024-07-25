package com.example.testinterview.service.impl;

import com.example.testinterview.baseLogger.BaseLogger;
import com.example.testinterview.domain.Account;
import com.example.testinterview.repository.AccountsRepository;
import com.example.testinterview.service.AccountsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl extends BaseLogger implements AccountsService {

    private final AccountsRepository accountsRepository;

    @Override
    public List<Account> findAccountsByBeneficiaryId(Long beneficiaryId) {
        logger.trace("Searching Accounts for Beneficiary Id:{}.", beneficiaryId);
        return accountsRepository.findAccountsByBeneficiaryId(beneficiaryId);
    }
}
