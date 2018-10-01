package com.api.worldtravelguide.message.response.province;

import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.dto.ProvinceDto;
import com.api.worldtravelguide.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProvinceListResponse extends BaseResponse {
    List<ProvinceDto> provinces;

    @Builder
    public ProvinceListResponse(ResponseCode responseCode, List<ProvinceDto> provinces) {
        super(responseCode);
        this.provinces = provinces;
    }
}
