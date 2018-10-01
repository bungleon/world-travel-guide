package com.api.worldtravelguide.message.response.neighborhood;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.NeighborhoodDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NeighborhoodListResponse extends BaseResponse {
    List<NeighborhoodDto> neighborhoods;

    @Builder
    public NeighborhoodListResponse(ResponseCode responseCode, List<NeighborhoodDto> neighborhoods) {
        super(responseCode);
        this.neighborhoods = neighborhoods;
    }
}
