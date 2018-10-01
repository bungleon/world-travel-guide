package com.api.worldtravelguide.service.district;

import com.api.worldtravelguide.domain.district.District;

import java.util.List;
import java.util.UUID;

public interface DistrictService {
    District getById(UUID id);

    List<District> geetDistrictList(UUID townId);

    District save(District district);
}
