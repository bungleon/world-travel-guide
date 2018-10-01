package com.api.worldtravelguide.handler.district;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.district.DistrictUpdateRequest;
import com.api.worldtravelguide.message.response.district.DistrictUpdateResponse;
import org.springframework.stereotype.Component;

@Component
public class DistrictUpdateHandler implements Handler<DistrictUpdateRequest, DistrictUpdateResponse> {
    @Override
    public DistrictUpdateResponse execute(DistrictUpdateRequest request) {
        return null;
    }
}
