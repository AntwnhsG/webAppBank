package com.example.testinterview.repository;

import com.example.testinterview.domain.Account;
import com.example.testinterview.exception.ReadCsvException;

import java.util.List;

public interface AccountsRepository {

    /**
     * Finds a list of accounts associated with the specified beneficiary ID.
     *
     * <p>This method retrieves all accounts that are linked to a particular beneficiary.
     * It will return a list of {@link Account} objects that are associated with the given beneficiary ID.
     * If no accounts are found for the provided beneficiary ID, an empty list will be returned.
     *
     * @param beneficiaryId the ID of the beneficiary whose associated accounts are to be retrieved
     * @return a list of {@link Account} objects associated with the given beneficiary ID
     * @throws ReadCsvException if any specific error occurs during the retrieval process, e.g., issues with data access
     *
     * @see Account
     */
    List<Account> findAccountsByBeneficiaryId(Long beneficiaryId);
}
