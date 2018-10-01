package com.api.worldtravelguide.handler.country;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.dto.CountryDto;
import com.api.worldtravelguide.message.request.country.CountryListRequest;
import com.api.worldtravelguide.message.response.country.CountryListResponse;
import com.api.worldtravelguide.service.country.CountryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryListHandler implements Handler<CountryListRequest, CountryListResponse> {
    private final CountryService countryService;

    public CountryListHandler(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public CountryListResponse execute(CountryListRequest request) {
        List<CountryDto> countryDtos = countryService.getCountryList().stream()
                .map(CountryDto::new)
                .collect(Collectors.toList());
        return CountryListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .countries(countryDtos)
                .build();
    }
}
