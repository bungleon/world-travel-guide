package com.api.worldtravelguide.message.request.town;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TownListRequest {
    private UUID provinceId;
}
