package com.api.worldtravelguide.handler.town;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.town.TownDetailRequest;
import com.api.worldtravelguide.message.response.town.TownDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class TownDetailHandler implements Handler<TownDetailRequest, TownDetailResponse> {
    @Override
    public TownDetailResponse execute(TownDetailRequest request) {
        return null;
    }
}
