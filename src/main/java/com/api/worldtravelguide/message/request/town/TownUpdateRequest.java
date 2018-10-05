package com.api.worldtravelguide.message.request.town;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class TownUpdateRequest {
    private UUID id;
    private String name;
    private String originalName;
    private String code;
    private String latitude;
    private String longitude;
    @NotNull
    private UUID provinceId;
}
