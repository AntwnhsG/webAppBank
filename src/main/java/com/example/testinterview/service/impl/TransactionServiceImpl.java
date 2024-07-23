package com.example.testinterview.service.impl;

import com.example.testinterview.domain.Transaction;
import com.example.testinterview.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<Transaction> findTransactionsByBeneficiaryId(Long id) {
        //TODO: Implement functionality
        return null;
    }
}
