package com.api.worldtravelguide.message.dto;

import com.api.worldtravelguide.domain.town.Town;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TownDto {
    private UUID id;
    private String name;
    private String originalName;
    private String code;
    private String latitude;
    private String longitude;
    public TownDto(Town town) {
        this.id = town.getId();
        this.name = town.getName();
        this.originalName = town.getOriginalName();
        this.code = town.getCode();
        this.latitude = town.getLatitude();
        this.longitude = town.getLongitude();
    }
}
