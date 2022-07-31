package com.fm22.controllers;

import com.fm22.dtos.TeamDto;
import com.fm22.services.TeamService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
public class TeamController {

    @Inject
    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @POST
    @Path("/create-team")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Uni<Response> createTeam(TeamDto teamDto){
        return teamService.createTeam(teamDto);
    }


    @GET
    @Path("/all-teams")
    @Blocking
    public Multi<Response> getAllTeams(){
        return teamService.getAllTeams();
    }

    //todo: @Transactional annotation is causing issues

    @DELETE
    @Path("/delete-team/{teamName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Blocking
    @Transactional
    public Uni<Response> deleteTeam(@PathParam("teamName") String teamName){
        return teamService.deleteTeam(teamName);
    }
}
