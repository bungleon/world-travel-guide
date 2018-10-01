package com.api.worldtravelguide.service.country;

import com.api.worldtravelguide.domain.country.Country;
import com.api.worldtravelguide.domain.country.CountryRepository;
import com.api.worldtravelguide.exception.domain_exception.CountryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country getById(UUID id) {
        return Optional.ofNullable(countryRepository.findByIdAndDeletedFalse(id))
                .orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public List<Country> getCountryList() {
        return countryRepository.findAllByDeletedFalse();
    }

    @Override
    public Country getByBinaryCode(String binaryCode) {
        return Optional.ofNullable(countryRepository.findByBinaryCodeAndDeletedFalse(binaryCode))
                .orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }
}
