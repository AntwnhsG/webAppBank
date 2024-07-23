package com.example.testinterview.repository;

import com.example.testinterview.domain.Transaction;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> findTransactionsByAccountId(Long accountId);
}
