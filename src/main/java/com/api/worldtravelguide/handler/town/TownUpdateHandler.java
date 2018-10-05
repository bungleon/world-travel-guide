package com.api.worldtravelguide.handler.town;

import com.api.worldtravelguide.domain.town.Town;
import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.exception.domain_exception.TownNotFoundException;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.town.TownUpdateRequest;
import com.api.worldtravelguide.message.response.town.TownUpdateResponse;
import com.api.worldtravelguide.service.province.ProvinceService;
import com.api.worldtravelguide.service.town.TownService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class TownUpdateHandler implements Handler<TownUpdateRequest, TownUpdateResponse> {
    private final TownService townService;
    private final ProvinceService provinceService;

    public TownUpdateHandler(TownService townService, ProvinceService provinceService) {
        this.townService = townService;
        this.provinceService = provinceService;
    }

    @Override
    public TownUpdateResponse execute(TownUpdateRequest request) {
        Town town;
        try {
            town = townService.getById(request.getId());
        } catch (TownNotFoundException e) {
            town = new Town();
        }

        if (!StringUtils.isEmpty(request.getCode())) {
            town.setCode(request.getCode());
        }

        if (!StringUtils.isEmpty(request.getLatitude())) {
            town.setLatitude(request.getLatitude());
        }

        if (!StringUtils.isEmpty(request.getLongitude())) {
            town.setLongitude(request.getLongitude());
        }

        if (!StringUtils.isEmpty(request.getName())) {
            town.setName(request.getName());
        }

        if (!StringUtils.isEmpty(request.getOriginalName())) {
            town.setOriginalName(request.getOriginalName());
        }

        if (request.getProvinceId() != null && town.getId() != null) {
            town.setProvince(provinceService.getById(request.getProvinceId()));
        }

        townService.save(town);

        return TownUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}
