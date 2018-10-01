package com.api.worldtravelguide.message.response.neighborhood;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NeighborhoodUpdateResponse extends BaseResponse {

    @Builder
    public NeighborhoodUpdateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}
