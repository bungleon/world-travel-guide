package com.api.worldtravelguide.handler.district;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.DistrictDto;
import com.api.worldtravelguide.message.request.district.DistrictDetailRequest;
import com.api.worldtravelguide.message.response.district.DistrictDetailResponse;
import com.api.worldtravelguide.service.district.DistrictService;
import org.springframework.stereotype.Component;

@Component
public class DistrictDetailHandler implements Handler<DistrictDetailRequest, DistrictDetailResponse> {
    private final DistrictService districtService;

    public DistrictDetailHandler(DistrictService districtService) {
        this.districtService = districtService;
    }

    @Override
    public DistrictDetailResponse execute(DistrictDetailRequest request) {
        DistrictDto districtDto = new DistrictDto(districtService.getById(request.getId()));

        return DistrictDetailResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .district(districtDto)
                .build();
    }
}
