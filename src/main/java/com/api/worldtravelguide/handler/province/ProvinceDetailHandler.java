package com.api.worldtravelguide.handler.province;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.ProvinceDto;
import com.api.worldtravelguide.message.request.province.ProvinceDetailRequest;
import com.api.worldtravelguide.message.response.province.ProvinceDetailResponse;
import com.api.worldtravelguide.service.province.ProvinceService;
import org.springframework.stereotype.Component;

@Component
public class ProvinceDetailHandler implements Handler<ProvinceDetailRequest, ProvinceDetailResponse> {
    private final ProvinceService provinceService;

    public ProvinceDetailHandler(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public ProvinceDetailResponse execute(ProvinceDetailRequest request) {
        ProvinceDto provinceDto = new ProvinceDto(provinceService.getById(request.getId()));

        return ProvinceDetailResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .province(provinceDto)
                .build();
    }
}
