package com.api.worldtravelguide.handler.neighborhood;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.NeighborhoodDto;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodDetailRequest;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodDetailResponse;
import com.api.worldtravelguide.service.neighborhood.NeighborhoodService;
import org.springframework.stereotype.Component;

@Component
public class NeighborhoodDetailHandler implements Handler<NeighborhoodDetailRequest, NeighborhoodDetailResponse> {
    private final NeighborhoodService neighborhoodService;

    public NeighborhoodDetailHandler(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    @Override
    public NeighborhoodDetailResponse execute(NeighborhoodDetailRequest request) {
        NeighborhoodDto neighborhood = new NeighborhoodDto(neighborhoodService.getById(request.getId()));

        return NeighborhoodDetailResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .neighborhood(neighborhood)
                .build();
    }
}
