package com.example.testinterview.repository.impl;

import com.example.testinterview.domain.Beneficiary;
import com.example.testinterview.repository.BeneficiaryRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Repository
public class BeneficiaryRepositoryImpl implements BeneficiaryRepository {

    @Override
    public Beneficiary readBeneficiaryById(Long id) {

        return findBeneficiary(id);
    }

    public Beneficiary findBeneficiary(Long id){

        InputStream csvFile = getClass().getClassLoader().getResourceAsStream("beneficiaries.csv");
        Beneficiary beneficiary = new Beneficiary();
        if (csvFile == null) {
            throw new RuntimeException("CSV file not found in resources.");
        }
        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(csvFile)).withSkipLines(1).build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                Long beneficiaryId = Long.parseLong(line[0]); // Assuming first column is ID
                if (beneficiaryId.equals(id)) {
                    beneficiary.setId(beneficiaryId);
                    beneficiary.setFirstName(line[1]);
                    beneficiary.setLastName(line[2]);
                }
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return beneficiary;
    }
}
