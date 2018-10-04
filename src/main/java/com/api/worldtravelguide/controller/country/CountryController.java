package com.api.worldtravelguide.controller.country;

import com.api.worldtravelguide.handler.country.CountryDetailHandler;
import com.api.worldtravelguide.handler.country.CountryListHandler;
import com.api.worldtravelguide.handler.country.CountryUpdateHandler;
import com.api.worldtravelguide.message.request.country.CountryDetailRequest;
import com.api.worldtravelguide.message.request.country.CountryListRequest;
import com.api.worldtravelguide.message.request.country.CountryUpdateRequest;
import com.api.worldtravelguide.message.response.country.CountryDetailResponse;
import com.api.worldtravelguide.message.response.country.CountryListResponse;
import com.api.worldtravelguide.message.response.country.CountryUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/country")
public class CountryController {
    private final CountryListHandler countryListHandler;
    private final CountryDetailHandler countryDetailHandler;
    private final CountryUpdateHandler countryUpdateHandler;

    public CountryController(CountryListHandler countryListHandler,
                             CountryDetailHandler countryDetailHandler,
                             CountryUpdateHandler countryUpdateHandler) {
        this.countryListHandler = countryListHandler;
        this.countryDetailHandler = countryDetailHandler;
        this.countryUpdateHandler = countryUpdateHandler;
    }

    @PostMapping("/list")
    public CountryListResponse getCountryList(@Valid @RequestBody CountryListRequest request) {
        return countryListHandler.execute(request);
    }

    @PostMapping("/detail")
    public CountryDetailResponse getCountryDetail(@Valid @RequestBody CountryDetailRequest request) {
        return countryDetailHandler.execute(request);
    }

    @PostMapping("/update")
    public CountryUpdateResponse updateCountry(@Valid @RequestBody CountryUpdateRequest request) {
        return countryUpdateHandler.execute(request);
    }
}
