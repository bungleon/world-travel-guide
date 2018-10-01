package com.api.worldtravelguide.handler.town;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.town.TownUpdateRequest;
import com.api.worldtravelguide.message.response.town.TownUpdateResponse;
import org.springframework.stereotype.Component;

@Component
public class TownUpdateHandler implements Handler<TownUpdateRequest, TownUpdateResponse> {
    @Override
    public TownUpdateResponse execute(TownUpdateRequest request) {
        return null;
    }
}
