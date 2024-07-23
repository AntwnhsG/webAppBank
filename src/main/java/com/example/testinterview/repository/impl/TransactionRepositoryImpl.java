package com.example.testinterview.repository.impl;

import com.example.testinterview.domain.Transaction;
import com.example.testinterview.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

//    private final TransactionRepository transactionRepository;
//
//    public TransactionRepositoryImpl(TransactionRepository transactionRepository){
//        this.transactionRepository = transactionRepository;
//    }

    @Override
    public List<Transaction> findTransactionsByAccountId(Long accountId) {
        //TODO: add functionality to read from csv file
        List<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
}
