package com.example.testinterview.repository.impl;

import com.example.testinterview.baseLogger.BaseLogger;
import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Transaction;
import com.example.testinterview.domain.enums.TransactionType;
import com.example.testinterview.exception.ReadCsvException;
import com.example.testinterview.repository.TransactionRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepositoryImpl extends BaseLogger implements TransactionRepository {

    @Override
    public List<Transaction> findTransactionsByAccounts(List<Account> accounts) throws ReadCsvException{

        List<Transaction> transactions = new ArrayList<>();
        accounts.forEach(account -> {
            InputStream csvFile = getClass().getClassLoader().getResourceAsStream("transactions.csv");
            if (csvFile == null) {
                throw new ReadCsvException("CSV file not found in resources.");
            }
            try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(csvFile)).withSkipLines(1).build()) {
                String[] line;
                while ((line = reader.readNext()) != null) {
                    Long accountIdFromCsv = Long.parseLong(line[1]);
                    logger.trace("Searching Transactions with Account Id:{}.", accountIdFromCsv);
                    if (accountIdFromCsv.equals(account.getId())) {
                        Transaction transaction = new Transaction();
                        transaction.setId(Long.valueOf(line[0]));
                        transaction.setAccountId(accountIdFromCsv);
                        transaction.setBalance(Double.valueOf(line[2]));
                        transaction.setType(TransactionType.fromString(line[3]));
                        transactions.add(transaction);
                    }
                }
            } catch (CsvValidationException | IOException e) {
                logger.error("CSV file transactions.csv is malformed or contains invalid data", e);
                throw new ReadCsvException("CSV file is malformed or contains invalid data");
            }
        });

        return transactions;
    }
}