package com.api.worldtravelguide.handler.neighborhood;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodListRequest;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodListResponse;
import org.springframework.stereotype.Component;

@Component
public class NeighborhoodListHandler implements Handler<NeighborhoodListRequest, NeighborhoodListResponse> {
    @Override
    public NeighborhoodListResponse execute(NeighborhoodListRequest request) {
        return null;
    }
}
