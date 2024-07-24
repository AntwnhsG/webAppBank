package com.example.testinterview.repository.impl;

import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Beneficiary;
import com.example.testinterview.domain.Transaction;
import com.example.testinterview.domain.enums.TransactionType;
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
public class TransactionRepositoryImpl implements TransactionRepository {


    @Override
    public List<Transaction> findTransactionsByAccounts(List<Account> accounts) {

        List<Transaction> transactions = new ArrayList<>();
        accounts.forEach(account -> {
            InputStream csvFile = getClass().getClassLoader().getResourceAsStream("transactions.csv");
            if (csvFile == null) {
                throw new RuntimeException("CSV file not found in resources.");
            }
            try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(csvFile)).withSkipLines(1).build()) {
                String[] line;
                while ((line = reader.readNext()) != null) {
                    Long accountIdFromCsv = Long.parseLong(line[1]); // Assuming first column is ID
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
                e.printStackTrace();
            }
        });

        return transactions; // or throw an exception if preferred
    }
}