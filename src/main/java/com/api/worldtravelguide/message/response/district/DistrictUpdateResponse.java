package com.api.worldtravelguide.message.response.district;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictUpdateResponse extends BaseResponse {
    @Builder
    public DistrictUpdateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}
