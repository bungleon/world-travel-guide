package com.api.worldtravelguide.handler.province;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.province.ProvinceDetailRequest;
import com.api.worldtravelguide.message.response.province.ProvinceDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class ProvinceDetailHandler implements Handler<ProvinceDetailRequest, ProvinceDetailResponse> {
    @Override
    public ProvinceDetailResponse execute(ProvinceDetailRequest request) {
        return null;
    }
}
