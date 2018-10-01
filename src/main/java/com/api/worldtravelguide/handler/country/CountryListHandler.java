package com.api.worldtravelguide.handler.country;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.country.CountryListRequest;
import com.api.worldtravelguide.message.response.country.CountryListResponse;
import org.springframework.stereotype.Component;

@Component
public class CountryListHandler implements Handler<CountryListRequest, CountryListResponse> {
    @Override
    public CountryListResponse execute(CountryListRequest request) {
        return null;
    }
}
