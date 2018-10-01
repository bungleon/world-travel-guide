package com.api.worldtravelguide.message.request.neighborhood;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class NeighborhoodListRequest {
    private UUID districtId;
}
