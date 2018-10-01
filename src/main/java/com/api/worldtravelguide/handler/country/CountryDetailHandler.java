package com.api.worldtravelguide.handler.country;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.CountryDto;
import com.api.worldtravelguide.message.request.country.CountryDetailRequest;
import com.api.worldtravelguide.message.response.country.CountryDetailResponse;
import com.api.worldtravelguide.service.country.CountryService;
import org.springframework.stereotype.Component;

@Component
public class CountryDetailHandler implements Handler<CountryDetailRequest, CountryDetailResponse> {
    private final CountryService countryService;

    public CountryDetailHandler(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public CountryDetailResponse execute(CountryDetailRequest request) {
        CountryDto countryDto = new CountryDto(countryService.getById(request.getId()));

        return CountryDetailResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .country(countryDto)
                .build();
    }
}
