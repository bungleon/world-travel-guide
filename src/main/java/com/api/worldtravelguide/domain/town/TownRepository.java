package com.api.worldtravelguide.domain.town;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TownRepository extends JpaRepository<Town, UUID> {
    Town findByIdAndDeletedFalse(UUID id);

    List<Town> findAllByProvinceIdAndDeletedFalse(UUID provinceId);
}
