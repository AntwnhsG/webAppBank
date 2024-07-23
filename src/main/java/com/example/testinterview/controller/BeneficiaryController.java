package com.example.testinterview.controller;

import com.example.testinterview.api.ApiResponse;
import com.example.testinterview.domain.Beneficiary;
import com.example.testinterview.service.BeneficiaryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    private final BeneficiaryService beneficiaryService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Beneficiary>> getBeneficiaryInfo(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(
                ApiResponse.<Beneficiary>builder().data(beneficiaryService.readBeneficiary(id)).build());
    }
}
