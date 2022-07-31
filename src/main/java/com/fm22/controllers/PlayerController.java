package com.fm22.controllers;

import com.fm22.dtos.PlayerDto;
import com.fm22.services.PlayerService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/player")
public class PlayerController {
    @Inject
    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @POST
    @Path("/create-player")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Uni<Response> createPlayer(PlayerDto playerDto) {
        return playerService.createPlayer(playerDto);

    }

    @GET
    @Path("/get-player/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Blocking
    public Uni<Response> getPlayer(@PathParam("id") Long id) {
        return playerService.getPlayer(id);
    }

    @GET
    @Path("/all-players")
    @Produces(MediaType.APPLICATION_JSON)
    @Blocking
    public Multi<Response> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PATCH
    @Path("/{playerId}/team/{teamId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Uni<Response> addPlayerToTeam(@PathParam("playerId") Long playerId,
                                    @PathParam("teamId") Long teamId) {
        return playerService.addPlayerToTeam(playerId, teamId);
    }

    @DELETE
    @Path("/delete-player/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Uni<Response> deletePlayer(@PathParam("playerId")Long playerId){
        return playerService.removePlayer(playerId);
    }
}
