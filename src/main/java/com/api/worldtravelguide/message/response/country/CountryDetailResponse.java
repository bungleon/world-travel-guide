package com.api.worldtravelguide.message.response.country;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.CountryDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDetailResponse extends BaseResponse {
    CountryDto country;

    @Builder
    public CountryDetailResponse(ResponseCode responseCode, CountryDto country) {
        super(responseCode);
        this.country = country;
    }
}
