package com.api.worldtravelguide.message.request.province;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class ProvinceUpdateRequest {
    private UUID id;
    private String name;
    private String originalName;
    private String code;
    private String phoneCode;
    private String latitude;
    private String longitude;
    @NotNull
    private UUID countryId;
}
