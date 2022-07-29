package com.fm22.controllers;

import com.fm22.dtos.TeamDto;
import com.fm22.services.TeamService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/teams")
public class TeamController {

    @Inject
    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @POST
    @Path("/create-team")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createTeam(TeamDto teamDto){
        return teamService.createTeam(teamDto);
    }

    @GET
    @Path("/all-teams")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTeams(){
        return teamService.getAllTeams();
    }

    @DELETE
    @Path("/delete-team/{teamName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteTeam(@PathParam("teamName") String teamName){
        return teamService.deleteTeam(teamName);
    }
}
