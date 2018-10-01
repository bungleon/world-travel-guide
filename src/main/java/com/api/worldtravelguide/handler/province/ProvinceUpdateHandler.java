package com.api.worldtravelguide.handler.province;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.province.ProvinceUpdateRequest;
import com.api.worldtravelguide.message.response.province.ProvinceUpdateResponse;
import org.springframework.stereotype.Component;

@Component
public class ProvinceUpdateHandler implements Handler<ProvinceUpdateRequest, ProvinceUpdateResponse> {
    @Override
    public ProvinceUpdateResponse execute(ProvinceUpdateRequest request) {
        return null;
    }
}
