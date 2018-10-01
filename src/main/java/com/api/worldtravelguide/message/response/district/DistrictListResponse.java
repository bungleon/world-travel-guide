package com.api.worldtravelguide.message.response.district;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.DistrictDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistrictListResponse extends BaseResponse {
    List<DistrictDto> districts;

    @Builder
    public DistrictListResponse(ResponseCode responseCode, List<DistrictDto> districts) {
        super(responseCode);
        this.districts = districts;
    }
}
