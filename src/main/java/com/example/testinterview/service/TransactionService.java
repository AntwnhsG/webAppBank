package com.example.testinterview.service;

import com.example.testinterview.domain.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findTransactionsByBeneficiaryId(Long id);
}
