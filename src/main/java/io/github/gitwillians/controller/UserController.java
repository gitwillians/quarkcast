package io.github.gitwillians.controller;

import org.jboss.resteasy.reactive.RestResponse;

import io.github.gitwillians.business.UserBusiness;
import io.github.gitwillians.entity.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;

@Path("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserBusiness business;
    
    @POST
    @Transactional
    public RestResponse<User> insert(final User entity, @Context UriInfo uriInfo) {
        System.out.println(entity);
        System.out.println(entity.getId());
        System.out.println(business.insert(entity));
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @GET
    @Path("/{id}")
    public RestResponse<User> findById(@PathParam("id") String id) {
        return RestResponse.ok(business.findById(id));
    }
}