package io.github.gitwillians.controller;

import org.jboss.resteasy.reactive.RestResponse;

import io.github.gitwillians.base.PageDTO;
import io.github.gitwillians.base.PageResponse;
import io.github.gitwillians.business.UserBusiness;
import io.github.gitwillians.entity.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
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

    @GET
    public RestResponse<PageResponse<User>> findPaged(
        @QueryParam("page") @DefaultValue("0") int page,
        @QueryParam("size") @DefaultValue("10") int size,
        @QueryParam("sort") @DefaultValue("createdAt") String sort,
        @QueryParam("asc") @DefaultValue("false") boolean asc) {

        PageDTO pageDTO =  PageDTO.builder().pageIndex(page).pageSize(size).sortBy(sort).ascending(asc).build();

        return RestResponse.ok(business.findPaged(pageDTO));
    }
}