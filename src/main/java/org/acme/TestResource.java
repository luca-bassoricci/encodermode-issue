package org.acme;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import io.smallrye.common.annotation.NonBlocking;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("test")
public class TestResource {

    @Inject
    @Named("json.codec")
    String jsonCodecRef;

    static Random R = new Random();

    private StringAndInt _generate() {
        return new StringAndInt(RandomStringUtils.randomAlphanumeric(30), R.nextInt(100));
    }

    @Path("wrapped")
    @GET
    @NonBlocking
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject wrapped() {
        return new JsonObject().put("wrapped",
                _generate());
    }

    @Path("json.codec")
    @GET
    @NonBlocking
    @Produces(MediaType.TEXT_PLAIN)
    public String jsonCODECRef() {
        return jsonCodecRef;
    }
}
