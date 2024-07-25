package com.example.testinterview.repository;

import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Transaction;
import com.example.testinterview.exception.ReadCsvException;

import java.util.List;

public interface TransactionRepository {

    /**
     * Retrieves a list of {@link Transaction} objects associated with the specified list of {@link Account} objects.
     *
     * <p>This method fetches transactions from the repository that are associated with the given list of accounts.
     * For each account in the provided list, it returns all transactions related to that account.
     * The returned list will include all matching transactions or be empty if no transactions are found for the given accounts.
     *
     * @param accounts a list of {@link Account} objects for which transactions are to be retrieved
     * @return a list of {@link Transaction} objects associated with the provided accounts
     * @throws ReadCsvException if any specific error occurs during the retrieval process, e.g., issues with data access
     *
     * @see Transaction
     * @see Account
     */
    List<Transaction> findTransactionsByAccounts(List<Account> accounts);
}
