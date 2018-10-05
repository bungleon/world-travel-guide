package com.api.worldtravelguide.handler.neighborhood;

import com.api.worldtravelguide.domain.neighborhood.Neighborhood;
import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.exception.domain_exception.NeighborhoodNotFoundException;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodUpdateRequest;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodUpdateResponse;
import com.api.worldtravelguide.service.district.DistrictService;
import com.api.worldtravelguide.service.neighborhood.NeighborhoodService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class NeighborhoodUpdateHandler implements Handler<NeighborhoodUpdateRequest, NeighborhoodUpdateResponse> {
    private final NeighborhoodService neighborhoodService;
    private final DistrictService districtService;

    public NeighborhoodUpdateHandler(NeighborhoodService neighborhoodService, DistrictService districtService) {
        this.neighborhoodService = neighborhoodService;
        this.districtService = districtService;
    }

    @Override
    public NeighborhoodUpdateResponse execute(NeighborhoodUpdateRequest request) {
        Neighborhood neighborhood;

        try {
            neighborhood = neighborhoodService.getById(request.getId());
        } catch (NeighborhoodNotFoundException e) {
            neighborhood = new Neighborhood();
        }

        if (!StringUtils.isEmpty(request.getCode())) {
            neighborhood.setCode(request.getCode());
        }

        if (!StringUtils.isEmpty(request.getLatitude())) {
            neighborhood.setLatitude(request.getLatitude());
        }

        if (!StringUtils.isEmpty(request.getLongitude())) {
            neighborhood.setLongitude(request.getLongitude());
        }

        if (!StringUtils.isEmpty(request.getName())) {
            neighborhood.setName(request.getName());
        }

        if (!StringUtils.isEmpty(request.getOriginalName())) {
            neighborhood.setOriginalName(request.getOriginalName());
        }

        if (request.getDistrictId() != null) {
            neighborhood.setDistrict(districtService.getById(request.getDistrictId()));
        }

        neighborhoodService.save(neighborhood);

        return NeighborhoodUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}
