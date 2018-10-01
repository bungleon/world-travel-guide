package com.api.worldtravelguide.message.request.country;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CountryUpdateRequest {
    private UUID id;
    private String name;
    private String binaryCode;
    private String tripleCode;
    private String phoneCode;
    private String latitude;
    private String longitude;
}
