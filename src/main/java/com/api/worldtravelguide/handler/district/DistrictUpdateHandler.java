package com.api.worldtravelguide.handler.district;

import com.api.worldtravelguide.domain.district.District;
import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.exception.domain_exception.DistrictNotFoundException;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.district.DistrictUpdateRequest;
import com.api.worldtravelguide.message.response.district.DistrictUpdateResponse;
import com.api.worldtravelguide.service.district.DistrictService;
import com.api.worldtravelguide.service.town.TownService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DistrictUpdateHandler implements Handler<DistrictUpdateRequest, DistrictUpdateResponse> {
    private final DistrictService districtService;
    private final TownService townService;

    public DistrictUpdateHandler(DistrictService districtService, TownService townService) {
        this.districtService = districtService;
        this.townService = townService;
    }

    @Override
    public DistrictUpdateResponse execute(DistrictUpdateRequest request) {
        District district;
        try {
            district = districtService.getById(request.getId());
        } catch (DistrictNotFoundException e) {
            district = new District();
        }

        if (!StringUtils.isEmpty(request.getCode())) {
            district.setCode(request.getCode());
        }

        if (!StringUtils.isEmpty(request.getLatitude())) {
            district.setLatitude(request.getLatitude());
        }

        if (!StringUtils.isEmpty(request.getLongitude())) {
            district.setLongitude(request.getLongitude());
        }

        if (!StringUtils.isEmpty(request.getName())) {
            district.setName(request.getName());
        }

        if (!StringUtils.isEmpty(request.getOriginalName())) {
            district.setOriginalName(request.getOriginalName());
        }

        if (request.getTownId() != null) {
            district.setTown(townService.getById(request.getTownId()));
        }

        districtService.save(district);

        return DistrictUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}
