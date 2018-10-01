package com.api.worldtravelguide.handler.country;

import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.country.CountryUpdateRequest;
import com.api.worldtravelguide.message.response.country.CountryUpdateResponse;
import org.springframework.stereotype.Component;

@Component
public class CountryUpdateHandler implements Handler<CountryUpdateRequest, CountryUpdateResponse> {
    @Override
    public CountryUpdateResponse execute(CountryUpdateRequest request) {
        return null;
    }
}
