package com.api.worldtravelguide.handler.district;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.district.DistrictDetailRequest;
import com.api.worldtravelguide.message.response.district.DistrictDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class DistrictDetailHandler implements Handler<DistrictDetailRequest, DistrictDetailResponse> {
    @Override
    public DistrictDetailResponse execute(DistrictDetailRequest request) {
        return null;
    }
}
