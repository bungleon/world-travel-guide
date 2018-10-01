package com.api.worldtravelguide.domain.province;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProvinceRepository extends JpaRepository<Province, UUID> {
    Province findByIdAndDeletedFalse(UUID id);

    List<Province> findAllByCountryIdAndDeletedFalse(UUID countryId);
}
