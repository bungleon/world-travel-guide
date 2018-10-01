package com.api.worldtravelguide.service.town;

import com.api.worldtravelguide.domain.town.Town;

import java.util.List;
import java.util.UUID;

public interface TownService {
    Town getById(UUID id);

    List<Town> getTownList(UUID provinceId);

    Town save(Town town);
}
