package com.example.testinterview.service;

import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionService {

    List<Transaction> findTransactionsByBeneficiaryId(Long beneficiaryId);

    Map<Long, Double> calculateAccountBalances(Long beneficiaryId);

}
