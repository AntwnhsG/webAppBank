package com.example.testinterview.service;

import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionService {

    /**
     * Retrieves a list of {@link Transaction} objects associated with the specified beneficiary ID.
     *
     * <p>This method fetches all {@link Transaction} entities that are linked to the given beneficiary ID.
     * It returns a list of transactions associated with the beneficiary. If no transactions are found
     * for the given beneficiary ID, an empty list will be returned.
     *
     * @param beneficiaryId the unique identifier of the beneficiary whose transactions are to be retrieved
     * @return a list of {@link Transaction} objects associated with the provided beneficiary ID, or an empty list if none are found
     *
     * @see Transaction
     */
    List<Transaction> findTransactionsByBeneficiaryId(Long beneficiaryId);

    /**
     * Calculates the balance for each account associated with the specified beneficiary ID.
     *
     * <p>This method computes the balance for each account linked to the given beneficiary ID by summing up
     * the transactions associated with those accounts. It returns a map where the key is the account ID and
     * the value is the calculated balance for that account.
     *
     * @param beneficiaryId the unique identifier of the beneficiary whose accounts' balances are to be calculated
     * @return a map where the key is the account ID and the value is the calculated balance for that account
     *
     * @see Transaction
     * @see Account
     */
    Map<Long, Double> calculateAccountBalances(Long beneficiaryId);

    /**
     * Finds the biggest withdrawal made from the accounts associated with the specified beneficiary ID.
     *
     * <p>This method retrieves the largest withdrawal amount across all accounts associated with the given
     * beneficiary ID. It returns a map where the key is the account ID and the value is the amount of the
     * biggest withdrawal made from that account. If no withdrawals are found, the map will be empty.
     *
     * <p>A withdrawal is defined as a transaction with a negative balance change (i.e., money taken out of
     * an account). The method assumes that withdrawals are stored with negative values representing the amount
     * withdrawn.
     *
     * @param beneficiaryId the unique identifier of the beneficiary whose accounts' withdrawals are to be analyzed
     * @return a map where the key is the account ID and the value is the amount of the biggest withdrawal made
     *         from that account; the map will be empty if no withdrawals are found
     *
     * @see Transaction
     * @see Account
     */
    Map<Long, Double> findLargestWithdrawalMadeFromBeneficiary(Long beneficiaryId);

}
