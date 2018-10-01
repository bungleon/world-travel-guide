package com.api.worldtravelguide.domain.country;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
}
