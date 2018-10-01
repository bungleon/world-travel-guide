package com.api.worldtravelguide.domain.neighborhood;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, UUID> {
    Neighborhood findByIdAndDeletedFalse(UUID id);

    List<Neighborhood> findAllByDistrictIdAndDeletedFalse(UUID districtId);
}
