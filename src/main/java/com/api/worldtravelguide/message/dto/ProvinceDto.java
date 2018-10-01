package com.api.worldtravelguide.message.dto;


import com.api.worldtravelguide.domain.province.Province;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProvinceDto {
    private UUID id;
    private String name;
    private String originalName;
    private String code;
    private String latitude;
    private String longitude;

    public ProvinceDto(Province province) {
        this.id = province.getId();
        this.name = province.getName();
        this.originalName = province.getOriginalName();
        this.code = province.getCode();
        this.latitude = province.getLatitude();
        this.longitude = province.getLongitude();
    }
}
