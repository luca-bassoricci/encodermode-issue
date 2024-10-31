package org.acme;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

public class JsonCodecProducer {

    @Produces
    @Named("json.codec")
    String jsonCodecRef() {
        return io.vertx.core.json.Json.CODEC.toString();
    }
}
