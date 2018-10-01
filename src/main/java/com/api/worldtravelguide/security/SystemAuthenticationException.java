package com.api.worldtravelguide.security;

import com.api.worldtravelguide.exception.ResponseCode;
import org.springframework.security.core.AuthenticationException;

public class SystemAuthenticationException extends AuthenticationException {

    private final ResponseCode responseCode;

    public SystemAuthenticationException(String msg, ResponseCode responseCode) {
        super(msg);
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
