package com.api.worldtravelguide.handler.town;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.TownDto;
import com.api.worldtravelguide.message.request.town.TownListRequest;
import com.api.worldtravelguide.message.response.town.TownListResponse;
import com.api.worldtravelguide.service.town.TownService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TownListHandler implements Handler<TownListRequest, TownListResponse> {
    private final TownService townService;

    public TownListHandler(TownService townService) {
        this.townService = townService;
    }

    @Override
    public TownListResponse execute(TownListRequest request) {
        List<TownDto> townDtos = townService.getTownList(request.getProvinceId()).stream()
                .map(TownDto::new)
                .collect(Collectors.toList());

        return TownListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .towns(townDtos)
                .build();
    }
}
