package com.api.worldtravelguide.service.province;

import com.api.worldtravelguide.domain.province.Province;

import java.util.List;
import java.util.UUID;

public interface ProvinceService {
    Province getById(UUID id);

    List<Province> getProvinceList(UUID countryId);

    Province save(Province province);
}
