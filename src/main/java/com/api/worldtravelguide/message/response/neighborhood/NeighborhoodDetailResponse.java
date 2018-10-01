package com.api.worldtravelguide.message.response.neighborhood;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.NeighborhoodDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NeighborhoodDetailResponse extends BaseResponse {
    private NeighborhoodDto neighborhood;

    @Builder
    public NeighborhoodDetailResponse(ResponseCode responseCode, NeighborhoodDto neighborhood) {
        super(responseCode);
        this.neighborhood = neighborhood;
    }
}
