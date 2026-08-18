package io.github.gitwillians.controller;

import org.jboss.resteasy.reactive.RestResponse;

import io.github.gitwillians.entity.User;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

@Path("/user")
public class UserController {

    @POST
    public RestResponse<Void> insert(final User entity, @Context UriInfo uriInfo) {
        System.out.println(entity);
        System.out.println(entity.getId());
        return RestResponse.created(uriInfo.getAbsolutePath());
    }
}