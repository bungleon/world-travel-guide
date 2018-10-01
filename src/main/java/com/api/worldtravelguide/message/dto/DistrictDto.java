package com.api.worldtravelguide.message.dto;

import com.api.worldtravelguide.domain.district.District;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DistrictDto {
    private UUID id;
    private String name;
    private String originalName;
    private String code;
    private String latitude;
    private String longitude;

    public DistrictDto(District district) {
        this.id = district.getId();
        this.name = district.getName();
        this.originalName = district.getOriginalName();
        this.code = district.getCode();
        this.latitude = district.getLatitude();
        this.longitude = district.getLongitude();
    }
}
