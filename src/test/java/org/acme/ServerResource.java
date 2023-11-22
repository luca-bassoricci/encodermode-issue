package org.acme;

import java.io.File;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestForm;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("server")
public class ServerResource {

    @Inject
    @RestClient
    ClientService client;

    @Path("test")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ResponseStatus(200)
    public void test(@RestForm File file) {
        client.upload(file);
    }
}
