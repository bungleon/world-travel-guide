package com.api.worldtravelguide.handler.province;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.province.ProvinceListRequest;
import com.api.worldtravelguide.message.response.province.ProvinceListResponse;
import org.springframework.stereotype.Component;

@Component
public class ProvinceListHandler implements Handler<ProvinceListRequest, ProvinceListResponse> {
    @Override
    public ProvinceListResponse execute(ProvinceListRequest request) {
        return null;
    }
}
