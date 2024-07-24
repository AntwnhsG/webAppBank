package com.example.testinterview.repository;

import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Transaction;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> findTransactionsByAccounts(List<Account> accounts);
}
