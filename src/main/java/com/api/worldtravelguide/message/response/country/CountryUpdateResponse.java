package com.api.worldtravelguide.message.response.country;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryUpdateResponse extends BaseResponse {
    @Builder
    public CountryUpdateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}
