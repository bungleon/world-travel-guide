package com.api.worldtravelguide.handler.neighborhood;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.NeighborhoodDto;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodListRequest;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodListResponse;
import com.api.worldtravelguide.service.neighborhood.NeighborhoodService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NeighborhoodListHandler implements Handler<NeighborhoodListRequest, NeighborhoodListResponse> {
    private final NeighborhoodService neighborhoodService;

    public NeighborhoodListHandler(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    @Override
    public NeighborhoodListResponse execute(NeighborhoodListRequest request) {
        List<NeighborhoodDto> neighborhoodList = neighborhoodService.getNeighborhoodList(request.getDistrictId()).stream()
                .map(NeighborhoodDto::new)
                .collect(Collectors.toList());

        return NeighborhoodListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .neighborhoods(neighborhoodList)
                .build();
    }
}
