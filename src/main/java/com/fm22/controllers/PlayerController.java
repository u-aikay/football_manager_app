package com.fm22.controllers;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerController {

    @POST
    @Path("/create")
    public Response createPlayer(String player) {


        return Response.ok().build();
    }

}
