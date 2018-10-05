package com.api.worldtravelguide.message.response;

import com.api.worldtravelguide.exception.ResponseCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends BaseResponse {
    @Builder
    public ErrorResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}
