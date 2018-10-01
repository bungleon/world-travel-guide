package com.api.worldtravelguide.service.district;

import com.api.worldtravelguide.domain.district.District;
import com.api.worldtravelguide.domain.district.DistrictRepository;
import com.api.worldtravelguide.exception.domain_exception.DistrictNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public District getById(UUID id) {
        return Optional.ofNullable(districtRepository.findByIdAndDeletedFalse(id))
                .orElseThrow(DistrictNotFoundException::new);
    }

    @Override
    public List<District> geetDistrictList(UUID townId) {
        return districtRepository.findAllByTownIdAndDeletedFalse(townId);
    }

    @Override
    public District save(District district) {
        return districtRepository.save(district);
    }
}
