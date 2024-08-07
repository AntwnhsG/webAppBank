package com.example.testinterview.controller;

import com.example.testinterview.api.ApiResponse;
import com.example.testinterview.domain.Transaction;
import com.example.testinterview.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Transaction>>> getTransactionsByBeneficiaryId(@PathVariable("id") final Long beneficiaryId) {
        return ResponseEntity.ok(
                ApiResponse.<List<Transaction>>builder().data(transactionService.findTransactionsByBeneficiaryId(beneficiaryId)).build());
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<ApiResponse<Map<Long, Double>>> getTransactionsBalanceOfAccountsByBeneficiaryId(@PathVariable("id") final Long beneficiaryId) {
        return ResponseEntity.ok(
                ApiResponse.<Map<Long, Double>>builder().data(transactionService.calculateAccountBalances(beneficiaryId)).build()
        );
    }

    @GetMapping("/max-withdrawal/{id}")
    public ResponseEntity<ApiResponse<Map<Long, Double>>> getLargestWithdrawalOfBeneficiaryId(@PathVariable("id") final Long beneficiaryId) {
        return ResponseEntity.ok(
                ApiResponse.<Map<Long, Double>>builder().data(transactionService.findLargestWithdrawalMadeFromBeneficiary(beneficiaryId)).build()
        );
    }
}
