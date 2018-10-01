package com.api.worldtravelguide.message.response.town;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TownUpdateResponse extends BaseResponse {
    @Builder
    public TownUpdateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}
