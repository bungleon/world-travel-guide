package com.api.worldtravelguide.handler.town;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.TownDto;
import com.api.worldtravelguide.message.request.town.TownDetailRequest;
import com.api.worldtravelguide.message.response.town.TownDetailResponse;
import com.api.worldtravelguide.service.town.TownService;
import org.springframework.stereotype.Component;

@Component
public class TownDetailHandler implements Handler<TownDetailRequest, TownDetailResponse> {
    private final TownService townService;

    public TownDetailHandler(TownService townService) {
        this.townService = townService;
    }

    @Override
    public TownDetailResponse execute(TownDetailRequest request) {
        TownDto townDto = new TownDto(townService.getById(request.getId()));

        return TownDetailResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .town(townDto)
                .build();
    }
}
