package com.api.worldtravelguide.handler.district;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.DistrictDto;
import com.api.worldtravelguide.message.request.district.DistrictListRequest;
import com.api.worldtravelguide.message.response.district.DistrictListResponse;
import com.api.worldtravelguide.service.district.DistrictService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictListHandler implements Handler<DistrictListRequest, DistrictListResponse> {
    private final DistrictService districtService;

    public DistrictListHandler(DistrictService districtService) {
        this.districtService = districtService;
    }

    @Override
    public DistrictListResponse execute(DistrictListRequest request) {
        List<DistrictDto> districtDtos = districtService.geetDistrictList(request.getTownId()).stream()
                .map(DistrictDto::new)
                .collect(Collectors.toList());

        return DistrictListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .districts(districtDtos)
                .build();
    }
}
