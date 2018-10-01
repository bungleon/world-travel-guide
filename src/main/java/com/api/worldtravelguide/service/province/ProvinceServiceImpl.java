package com.api.worldtravelguide.service.province;

import com.api.worldtravelguide.domain.province.Province;
import com.api.worldtravelguide.domain.province.ProvinceRepository;
import com.api.worldtravelguide.exception.domain_exception.ProvinceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepository;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Province getById(UUID id) {
        return Optional.ofNullable(provinceRepository.findByIdAndDeletedFalse(id))
                .orElseThrow(ProvinceNotFoundException::new);
    }

    @Override
    public List<Province> getProvinceList(UUID countryId) {
        return provinceRepository.findAllByCountryIdAndDeletedFalse(countryId);
    }

    @Override
    public Province save(Province province) {
        return provinceRepository.save(province);
    }
}
