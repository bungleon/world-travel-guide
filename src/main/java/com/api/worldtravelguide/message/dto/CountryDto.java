package com.api.worldtravelguide.message.dto;

import com.api.worldtravelguide.domain.country.Country;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CountryDto {
    private UUID id;
    private String name;
    private String binaryCode;
    private String tripleCode;
    private String phoneCode;
    private String latitude;
    private String longitude;

    public CountryDto(Country country) {
        this.id = country.getId();
        this.name = country.getName();
        this.binaryCode = country.getBinaryCode();
        this.tripleCode = country.getTripleCode();
        this.phoneCode = country.getPhoneCode();
        this.latitude = country.getLatitude();
        this.longitude = country.getLongitude();
    }
}
