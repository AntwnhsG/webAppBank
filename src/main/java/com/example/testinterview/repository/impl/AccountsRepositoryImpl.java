package com.example.testinterview.repository.impl;

import com.example.testinterview.baseLogger.BaseLogger;
import com.example.testinterview.domain.Account;
import com.example.testinterview.exception.ReadCsvException;
import com.example.testinterview.repository.AccountsRepository;
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
public class AccountsRepositoryImpl extends BaseLogger implements AccountsRepository{

    @Override
    public List<Account> findAccountsByBeneficiaryId(Long beneficiaryId) throws ReadCsvException{

        InputStream csvFile = getClass().getClassLoader().getResourceAsStream("accounts.csv");
        List<Account> beneficiaryAccounts = new ArrayList<>();
        if (csvFile == null) {
            throw new ReadCsvException("CSV file not found in resources");
        }
        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(csvFile)).withSkipLines(1).build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                Long beneficiaryIdFromCsv = Long.parseLong(line[1]);
                if (beneficiaryIdFromCsv.equals(beneficiaryId)) {
                    Account account = new Account();
                    account.setId(Long.valueOf(line[0]));
                    account.setBeneficiaryId(beneficiaryIdFromCsv);
                    beneficiaryAccounts.add(account);
                }
            }
        } catch (CsvValidationException | IOException e) {
            logger.error("CSV file transactions.csv is malformed or contains invalid data");
            throw new ReadCsvException("CSV file is malformed or contains invalid data");
        }

        return beneficiaryAccounts;
    }
}
