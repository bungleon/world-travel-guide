package com.api.worldtravelguide.domain.district;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District, UUID> {
    District findByIdAndDeletedFalse(UUID id);

    List<District> findAllByTownIdAndDeletedFalse(UUID townId);
}
