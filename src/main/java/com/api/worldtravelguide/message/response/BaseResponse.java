package com.api.worldtravelguide.message.response;

import com.api.worldtravelguide.exception.ResponseCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private Integer code;
    private String message;

    public BaseResponse(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
