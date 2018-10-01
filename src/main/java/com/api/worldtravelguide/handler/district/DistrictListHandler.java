package com.api.worldtravelguide.handler.district;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.district.DistrictListRequest;
import com.api.worldtravelguide.message.response.district.DistrictListResponse;
import org.springframework.stereotype.Component;

@Component
public class DistrictListHandler implements Handler<DistrictListRequest, DistrictListResponse> {
    @Override
    public DistrictListResponse execute(DistrictListRequest request) {
        return null;
    }
}
