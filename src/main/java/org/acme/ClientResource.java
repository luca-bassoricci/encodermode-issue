package org.acme;

import java.io.File;

import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestForm;

import io.quarkus.arc.Unremovable;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("client")
@Unremovable
public class ClientResource {
    @Path("upload")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ResponseStatus(200)
    public void upload(@RestForm File file) {

    }
}
