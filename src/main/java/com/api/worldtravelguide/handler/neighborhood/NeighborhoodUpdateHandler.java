package com.api.worldtravelguide.handler.neighborhood;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodUpdateRequest;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodUpdateResponse;
import org.springframework.stereotype.Component;

@Component
public class NeighborhoodUpdateHandler implements Handler<NeighborhoodUpdateRequest, NeighborhoodUpdateResponse> {
    @Override
    public NeighborhoodUpdateResponse execute(NeighborhoodUpdateRequest request) {
        return null;
    }
}
