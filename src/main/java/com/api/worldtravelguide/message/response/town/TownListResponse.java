package com.api.worldtravelguide.message.response.town;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.TownDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TownListResponse extends BaseResponse {
    private List<TownDto> towns;

    @Builder
    public TownListResponse(ResponseCode responseCode, List<TownDto> towns) {
        super(responseCode);
        this.towns = towns;
    }
}
