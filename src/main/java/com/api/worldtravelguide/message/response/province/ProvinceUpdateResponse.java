package com.api.worldtravelguide.message.response.province;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceUpdateResponse extends BaseResponse {

    @Builder
    public ProvinceUpdateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}
