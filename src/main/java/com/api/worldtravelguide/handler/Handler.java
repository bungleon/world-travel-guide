package com.api.worldtravelguide.handler;

public interface Handler<E, O> {
    O execute(E request);
}
