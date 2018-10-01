package com.api.worldtravelguide.message.dto;

import com.api.worldtravelguide.domain.neighborhood.Neighborhood;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class NeighborhoodDto {
    private UUID id;
    private String name;
    private String originalName;
    private String code;
    private String latitude;
    private String longitude;

    public NeighborhoodDto(Neighborhood neighborhood) {
        this.id = neighborhood.getId();
        this.name = neighborhood.getName();
        this.originalName = neighborhood.getOriginalName();
        this.code = neighborhood.getCode();
        this.latitude = neighborhood.getLatitude();
        this.longitude = neighborhood.getLongitude();
    }
}
