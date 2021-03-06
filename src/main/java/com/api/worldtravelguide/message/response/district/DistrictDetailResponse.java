package com.api.worldtravelguide.message.response.district;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.DistrictDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictDetailResponse extends BaseResponse {
    DistrictDto district;

    @Builder
    public DistrictDetailResponse(ResponseCode responseCode, DistrictDto district) {
        super(responseCode);
        this.district = district;
    }
}
