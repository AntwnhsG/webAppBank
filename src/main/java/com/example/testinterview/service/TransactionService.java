package com.example.testinterview.service;

import com.example.testinterview.domain.Transaction;

public interface TransactionService {

    Transaction findTransactionsByAccountId(Long id);
}
