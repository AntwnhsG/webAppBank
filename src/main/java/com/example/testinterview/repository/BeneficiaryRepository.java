package com.example.testinterview.repository;

import com.example.testinterview.domain.Beneficiary;
import com.example.testinterview.exception.ReadCsvException;

public interface BeneficiaryRepository {

    /**
     * Retrieves a {@link Beneficiary} by its unique identifier.
     *
     * <p>This method fetches a {@link Beneficiary} entity from the repository using the provided beneficiary ID.
     * If a beneficiary with the specified ID exists, it is returned; otherwise, the method may return {@code null}.
     *
     * @param id the unique identifier of the beneficiary to be retrieved
     * @return the {@link Beneficiary} entity associated with the given ID, or {@code null} if no such beneficiary is found
     * @throws ReadCsvException if any specific error occurs during the retrieval process, e.g., issues with data access
     *
     * @see Beneficiary
     */
    Beneficiary readBeneficiaryById(Long id);
}
