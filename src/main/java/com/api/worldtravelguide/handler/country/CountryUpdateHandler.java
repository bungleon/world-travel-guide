package com.api.worldtravelguide.handler.country;

import com.api.worldtravelguide.domain.country.Country;
import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.exception.domain_exception.CountryNotFoundException;
import com.api.worldtravelguide.handler.Handler;
import com.api.worldtravelguide.message.request.country.CountryUpdateRequest;
import com.api.worldtravelguide.message.response.country.CountryUpdateResponse;
import com.api.worldtravelguide.service.country.CountryService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CountryUpdateHandler implements Handler<CountryUpdateRequest, CountryUpdateResponse> {
    private final CountryService countryService;

    public CountryUpdateHandler(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public CountryUpdateResponse execute(CountryUpdateRequest request) {
        Country country;
        try {
            country = countryService.getById(request.getId());
        } catch (CountryNotFoundException e) {
            country = new Country();
        }
        if (!StringUtils.isEmpty(request.getName())) {
            country.setName(request.getName());
        }

        if (!StringUtils.isEmpty(request.getLatitude())) {
            country.setLatitude(request.getLatitude());
        }

        if (!StringUtils.isEmpty(request.getLongitude())) {
            country.setLongitude(request.getLongitude());
        }

        if (!StringUtils.isEmpty(request.getTripleCode())) {
            country.setTripleCode(request.getTripleCode());
        }

        if (!StringUtils.isEmpty(request.getBinaryCode())) {
            country.setBinaryCode(request.getBinaryCode());
        }

        if (!StringUtils.isEmpty(request.getPhoneCode())) {
            country.setPhoneCode(request.getPhoneCode());
        }

        countryService.save(country);

        return CountryUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}
