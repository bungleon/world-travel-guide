package com.api.worldtravelguide.exception.domain_exception;

import com.api.worldtravelguide.exception.DomainException;
import com.api.worldtravelguide.exception.ExceptionMessage;
import com.api.worldtravelguide.exception.ResponseCode;

@ExceptionMessage(responseCode = ResponseCode.TOWN_NOT_FOUND)
public class TownNotFoundException extends DomainException {
}
