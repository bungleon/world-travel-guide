package com.api.worldtravelguide.message.request.district;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DistrictUpdateRequest {
    private UUID id;
    private String name;
    private String originalName;
    private String code;
    private String latitude;
    private String longitude;
    private UUID townId;
}
