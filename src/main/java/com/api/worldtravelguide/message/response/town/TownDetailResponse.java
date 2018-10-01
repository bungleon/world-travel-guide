package com.api.worldtravelguide.message.response.town;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.TownDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TownDetailResponse extends BaseResponse {
    private TownDto town;

    @Builder
    public TownDetailResponse(ResponseCode responseCode, TownDto town) {
        super(responseCode);
        this.town = town;
    }
}
