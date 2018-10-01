package com.api.worldtravelguide.service.neighborhood;

import com.api.worldtravelguide.domain.neighborhood.Neighborhood;
import com.api.worldtravelguide.domain.neighborhood.NeighborhoodRepository;
import com.api.worldtravelguide.exception.domain_exception.NeighborhoodNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodServiceImpl(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    @Override
    public Neighborhood getById(UUID id) {
        return Optional.ofNullable(neighborhoodRepository.findByIdAndDeletedFalse(id))
                .orElseThrow(NeighborhoodNotFoundException::new);
    }

    @Override
    public List<Neighborhood> getNeighborhoodList(UUID districtId) {
        return neighborhoodRepository.findAllByDistrictIdAndDeletedFalse(districtId);
    }

    @Override
    public Neighborhood save(Neighborhood neighborhood) {
        return neighborhoodRepository.save(neighborhood);
    }
}
