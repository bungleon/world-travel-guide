package com.api.worldtravelguide.message.response.country;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.CountryDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryListResponse extends BaseResponse {
    List<CountryDto> countries;

    @Builder
    public CountryListResponse(ResponseCode responseCode, List<CountryDto> countries) {
        super(responseCode);
        this.countries = countries;
    }
}
