package com.api.worldtravelguide.handler.province;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.ProvinceDto;
import com.api.worldtravelguide.message.request.province.ProvinceListRequest;
import com.api.worldtravelguide.message.response.province.ProvinceListResponse;
import com.api.worldtravelguide.service.province.ProvinceService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProvinceListHandler implements Handler<ProvinceListRequest, ProvinceListResponse> {
    private final ProvinceService provinceService;

    public ProvinceListHandler(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public ProvinceListResponse execute(ProvinceListRequest request) {
        List<ProvinceDto> provinceDtos = provinceService.getProvinceList(request.getCountryId()).stream()
                .map(ProvinceDto::new)
                .collect(Collectors.toList());

        return ProvinceListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .provinces(provinceDtos)
                .build();
    }
}
