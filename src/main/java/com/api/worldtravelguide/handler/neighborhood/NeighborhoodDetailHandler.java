package com.api.worldtravelguide.handler.neighborhood;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodDetailRequest;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class NeighborhoodDetailHandler implements Handler<NeighborhoodDetailRequest, NeighborhoodDetailResponse> {
    @Override
    public NeighborhoodDetailResponse execute(NeighborhoodDetailRequest request) {
        return null;
    }
}
