package com.api.worldtravelguide.exception;

public class DomainException extends RuntimeException {
    public DomainException() {
    }

    public DomainException(String message) {
        super(message);
    }
}
