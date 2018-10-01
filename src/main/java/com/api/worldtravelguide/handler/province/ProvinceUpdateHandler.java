package com.api.worldtravelguide.handler.province;

import com.api.worldtravelguide.domain.province.Province;
import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.exception.domain_exception.ProvinceNotFoundException;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.province.ProvinceUpdateRequest;
import com.api.worldtravelguide.message.response.province.ProvinceUpdateResponse;
import com.api.worldtravelguide.service.province.ProvinceService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ProvinceUpdateHandler implements Handler<ProvinceUpdateRequest, ProvinceUpdateResponse> {
    private final ProvinceService provinceService;

    public ProvinceUpdateHandler(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public ProvinceUpdateResponse execute(ProvinceUpdateRequest request) {
        Province province;
        try {
            province = provinceService.getById(request.getId());
        } catch (ProvinceNotFoundException e) {
            province = new Province();
        }
        if (!StringUtils.isEmpty(request.getCode())) {
            province.setCode(request.getCode());
        }

        if (!StringUtils.isEmpty(request.getLatitude())) {
            province.setLatitude(request.getLatitude());
        }

        if (!StringUtils.isEmpty(request.getLongitude())) {
            province.setLongitude(request.getLongitude());
        }

        if (!StringUtils.isEmpty(request.getName())) {
            province.setName(request.getName());
        }

        if (!StringUtils.isEmpty(request.getOriginalName())) {
            province.setOriginalName(request.getOriginalName());
        }

        if (!StringUtils.isEmpty(request.getPhoneCode())) {
            province.setPhoneCode(request.getPhoneCode());
        }
        return ProvinceUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}
