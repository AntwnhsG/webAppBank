package com.example.testinterview.service;

import com.example.testinterview.domain.Beneficiary;

public interface BeneficiaryService {

    /**
     * Retrieves a {@link Beneficiary} entity by its unique identifier.
     *
     * <p>This method fetches a {@link Beneficiary} from the repository or service using the provided beneficiary ID.
     * If a beneficiary with the specified ID exists, it is returned; otherwise, the method may return {@code null}.
     *
     * @param id the unique identifier of the beneficiary to be retrieved
     * @return the {@link Beneficiary} entity associated with the given ID, or {@code null} if no such beneficiary is found
     *
     * @see Beneficiary
     */
    Beneficiary readBeneficiary(Long id);
}
