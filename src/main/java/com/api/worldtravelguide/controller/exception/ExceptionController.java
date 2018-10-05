package com.api.worldtravelguide.controller.exception;

import com.api.worldtravelguide.exception.DomainException;
import com.api.worldtravelguide.exception.ExceptionMessage;
import com.api.worldtravelguide.exception.ResponseCode;
import com.api.worldtravelguide.message.response.ErrorResponse;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DomainException.class)
    public ErrorResponse domainException(DomainException ex) {
        ExceptionMessage exceptionMessage = AnnotationUtils.findAnnotation(ex.getClass(), ExceptionMessage.class);
        return ErrorResponse.builder()
                .responseCode(exceptionMessage.responseCode())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse error(Exception ex) {
        return ErrorResponse.builder()
                .responseCode(ResponseCode.UNDEFINED_ERROR)
                .build();
    }


}
