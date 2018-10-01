package com.api.worldtravelguide.handler.country;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.country.CountryDetailRequest;
import com.api.worldtravelguide.message.response.country.CountryDetailResponse;
import lombok.Builder;

@Builder
public class CountryDetailHandler implements Handler<CountryDetailRequest, CountryDetailResponse> {
    @Override
    public CountryDetailResponse execute(CountryDetailRequest request) {
        return null;
    }
}
