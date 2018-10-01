package com.api.worldtravelguide.domain.country;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
    Country findByIdAndDeletedFalse(UUID id);

    Country findByBinaryCodeAndDeletedFalse(String binaryCode);

    List<Country> findAllByDeletedFalse();
}
