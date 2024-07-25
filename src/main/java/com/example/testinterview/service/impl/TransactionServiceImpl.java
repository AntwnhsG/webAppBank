package com.example.testinterview.service.impl;

import com.example.testinterview.baseLogger.BaseLogger;
import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Beneficiary;
import com.example.testinterview.domain.Transaction;
import com.example.testinterview.domain.enums.TransactionType;
import com.example.testinterview.repository.AccountsRepository;
import com.example.testinterview.repository.TransactionRepository;
import com.example.testinterview.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl extends BaseLogger implements TransactionService {

    private final AccountsRepository accountsRepository;

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findTransactionsByBeneficiaryId(Long beneficiaryId) {

        List<Account> accounts = accountsRepository.findAccountsByBeneficiaryId(beneficiaryId);
        return transactionRepository.findTransactionsByAccounts(accounts);
    }

    @Override
    public Map<Long, Double> calculateAccountBalances(Long beneficiaryId) {

        List<Transaction> transactions = findTransactionsByBeneficiaryId(beneficiaryId);
        logger.trace("Find balance based on Transactions made for Beneficiary with Id:{}", beneficiaryId);
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getAccountId,
                        Collectors.summingDouble(transaction ->
                                // If transactions is WITHDRAWAL subtract from balance
                                // Else add to balance
                                transaction.getType() == TransactionType.WITHDRAWAL
                                        ? -transaction.getBalance()
                                        : transaction.getBalance()
                        )
                ));
    }

    @Override
    public Map<Long, Double> findLargestWithdrawalMadeFromBeneficiary(Long beneficiaryId) {

        List<Transaction> transactions = findTransactionsByBeneficiaryId(beneficiaryId);
        logger.trace("Find largest Withdrawal made for Beneficiary with Id:{}", beneficiaryId);
        return transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.WITHDRAWAL)
                .collect(Collectors.groupingBy(
                        id -> beneficiaryId, // Group by Beneficiary ID
                        Collectors.mapping(
                                Transaction::getBalance, // Extract the withdrawal amount
                                Collectors.maxBy(Comparator.naturalOrder()) // Find the maximum withdrawal
                        )
                ))
                .entrySet().stream()
                // Convert Optional<Double> to Double
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // Account ID
                        entry -> entry.getValue().orElse(0.0) // Handle the Optional, default to 0.0 if no withdrawals
                ));
    }


}
