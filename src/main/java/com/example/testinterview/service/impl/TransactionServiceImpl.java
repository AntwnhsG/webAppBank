package com.example.testinterview.service.impl;

import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Transaction;
import com.example.testinterview.domain.enums.TransactionType;
import com.example.testinterview.repository.AccountsRepository;
import com.example.testinterview.repository.TransactionRepository;
import com.example.testinterview.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

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

        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getAccountId,
                        Collectors.summingDouble(transaction ->
                                transaction.getType() == TransactionType.WITHDRAWAL
                                        ? -transaction.getBalance()
                                        : transaction.getBalance()
                        )
                ));
    }


}
