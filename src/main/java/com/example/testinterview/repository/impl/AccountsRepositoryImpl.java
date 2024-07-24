package com.example.testinterview.repository.impl;

import com.example.testinterview.domain.Account;
import com.example.testinterview.domain.Beneficiary;
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
public class AccountsRepositoryImpl implements AccountsRepository {

    @Override
    public List<Account> findAccountsByBeneficiaryId(Long beneficiaryId) {

        InputStream csvFile = getClass().getClassLoader().getResourceAsStream("accounts.csv");
        List<Account> beneficiaryAccounts = new ArrayList<>();
        if (csvFile == null) {
            throw new RuntimeException("CSV file not found in resources.");
        }
        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(csvFile)).withSkipLines(1).build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                Long beneficiaryIdFromCsv = Long.parseLong(line[1]); // Assuming first column is ID
                if (beneficiaryIdFromCsv.equals(beneficiaryId)) {
                    Account account = new Account();
                    account.setId(Long.valueOf(line[0]));
                    account.setBeneficiaryId(beneficiaryIdFromCsv);
                    beneficiaryAccounts.add(account);
                }
            }
            return beneficiaryAccounts;
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return beneficiaryAccounts;
    }
}
