package com.api.worldtravelguide.message.response.province;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.ProvinceDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceDetailResponse extends BaseResponse {
    ProvinceDto province;

    @Builder
    public ProvinceDetailResponse(ResponseCode responseCode, ProvinceDto province) {
        super(responseCode);
        this.province = province;
    }
}
