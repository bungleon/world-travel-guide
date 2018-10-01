package com.api.worldtravelguide.message.request.district;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DistrictListRequest {
    private UUID countryId;
}
