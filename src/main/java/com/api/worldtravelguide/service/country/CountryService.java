package com.api.worldtravelguide.service.country;

import com.api.worldtravelguide.domain.country.Country;

import java.util.List;
import java.util.UUID;

public interface CountryService {
    Country getById(UUID id);

    List<Country> getCountryList();

    Country getByBinaryCode(String binaryCode);

    Country save(Country country);
}
