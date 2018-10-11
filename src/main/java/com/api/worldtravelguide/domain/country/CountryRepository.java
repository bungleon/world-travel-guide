package com.api.worldtravelguide.domain.country;

import com.api.worldtravelguide.domain.custom_repository.CustomRepository;

import java.util.List;
import java.util.UUID;

public interface CountryRepository extends CustomRepository<Country, UUID> {
    Country findByIdAndDeletedFalse(UUID id);

    Country findByBinaryCodeAndDeletedFalse(String binaryCode);

    List<Country> findAllByDeletedFalse();
}
