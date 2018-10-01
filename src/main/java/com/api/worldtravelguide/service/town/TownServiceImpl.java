package com.api.worldtravelguide.service.town;

import com.api.worldtravelguide.domain.town.Town;
import com.api.worldtravelguide.domain.town.TownRepository;
import com.api.worldtravelguide.exception.domain_exception.TownNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public Town getById(UUID id) {
        return Optional.ofNullable(townRepository.findByIdAndDeletedFalse(id))
                .orElseThrow(TownNotFoundException::new);
    }

    @Override
    public List<Town> getTownList(UUID provinceId) {
        return townRepository.findAllByProvinceIdAndDeletedFalse(provinceId);
    }

    @Override
    public Town save(Town town) {
        return townRepository.save(town);
    }
}
