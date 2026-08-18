package io.github.gitwillians;

import org.jboss.resteasy.reactive.RestResponse;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("/teste")
    public RestResponse<String> he() {
        return RestResponse.ok("Hello from Quarkus REST");
    }
}
