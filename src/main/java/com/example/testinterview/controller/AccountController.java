package com.example.testinterview.controller;

import com.example.testinterview.api.ApiResponse;
import com.example.testinterview.domain.Account;
import com.example.testinterview.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountsService accountsService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Account>>> findAccountsByBeneficiaryId(@PathVariable("id") Long beneficiaryId) {
        return ResponseEntity.ok(
                ApiResponse.<List<Account>>builder().data(accountsService.findAccountsByBeneficiaryId(beneficiaryId)).build());
    }
}
