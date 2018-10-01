package com.api.worldtravelguide.handler.town;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.town.TownListRequest;
import com.api.worldtravelguide.message.response.town.TownListResponse;
import org.springframework.stereotype.Component;

@Component
public class TownListHandler implements Handler<TownListRequest, TownListResponse> {
    @Override
    public TownListResponse execute(TownListRequest request) {
        return null;
    }
}
