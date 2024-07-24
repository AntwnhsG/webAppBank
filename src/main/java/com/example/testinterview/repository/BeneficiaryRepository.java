package com.example.testinterview.repository;

import com.example.testinterview.domain.Beneficiary;

public interface BeneficiaryRepository {
    Beneficiary readBeneficiaryById(Long id);
}
