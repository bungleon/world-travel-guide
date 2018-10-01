package com.api.worldtravelguide.service.neighborhood;

import com.api.worldtravelguide.domain.neighborhood.Neighborhood;

import java.util.List;
import java.util.UUID;

public interface NeighborhoodService {
    Neighborhood getById(UUID id);

    List<Neighborhood> getNeighborhoodList(UUID districtId);

    Neighborhood save(Neighborhood neighborhood);
}
