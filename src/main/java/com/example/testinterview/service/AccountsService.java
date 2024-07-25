package com.example.testinterview.service;

import com.example.testinterview.domain.Account;

import java.util.List;

public interface AccountsService {

    /**
     * Retrieves a list of {@link Account} objects associated with the specified beneficiary ID.
     *
     * <p>This method fetches all {@link Account} entities that are linked to the given beneficiary ID.
     * It will return a list of accounts associated with the provided beneficiary ID. If no accounts are found
     * for the given beneficiary ID, an empty list will be returned.
     *
     * @param beneficiaryId the unique identifier of the beneficiary whose associated accounts are to be retrieved
     * @return a list of {@link Account} objects associated with the provided beneficiary ID, or an empty list if none are found
     *
     * @see Account
     */
    List<Account> findAccountsByBeneficiaryId(Long beneficiaryId);
}
