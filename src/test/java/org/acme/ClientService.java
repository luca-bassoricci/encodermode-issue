package org.acme;

import java.io.File;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("client")
@RegisterRestClient(configKey = "client")
@ApplicationScoped
@Unremovable
public interface ClientService {
    @Path("upload")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    Response upload(@FormParam("file") File file);
}
