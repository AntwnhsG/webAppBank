package com.example.testinterview.service.impl;

import com.example.testinterview.baseLogger.BaseLogger;
import com.example.testinterview.domain.Beneficiary;
import com.example.testinterview.repository.BeneficiaryRepository;
import com.example.testinterview.service.BeneficiaryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeneficiaryServiceImpl extends BaseLogger implements BeneficiaryService {

    private final BeneficiaryRepository beneficiaryRepository;

    @Override
    public Beneficiary readBeneficiary(Long id) {
        logger.trace("Searching Beneficiary with Id:{}", id);
        return beneficiaryRepository.readBeneficiaryById(id);
    }
}
