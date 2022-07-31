package com.fm22.services.seviceImpl;

import com.fm22.dtos.PlayerDto;
import com.fm22.models.Players;
import com.fm22.models.Team;
import com.fm22.services.PlayerService;
import io.smallrye.common.constraint.NotNull;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;


@ApplicationScoped
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    @Override
    public Uni<Response> createPlayer(@NotNull PlayerDto playerDto) {
        Players player1 = Players.find("firstName", playerDto.getFirstName()).firstResult();
        if (player1 != null) {
            return Uni.createFrom().item(Response.status(Response.Status.CONFLICT)
                    .entity("PLAYER ALREADY EXIST").build());
        }
        Players player = Players.builder()
                .firstName(playerDto.getFirstName())
                .lastName(playerDto.getLastName())
                .position(playerDto.getPosition())
                .number(playerDto.getNumber())
                .build();
        player.persist();
        return Uni.createFrom().item(Response.status(Response.Status.CREATED)
                .entity(player).build());
    }

    @Override
    public Uni<Response> getPlayer(Long id) {
        Players player = Players.findById(id);
        if (player == null) {
            return Uni.createFrom().item(Response.status(Response.Status.NOT_FOUND)
                    .entity("PLAYER NOT FOUND").build());
        }
        return Uni.createFrom().item(Response.status(Response.Status.OK)
                .entity(player).build());
    }

    @Override
    public Multi<Response> getAllPlayers() {
        List<Players> allPlayers = Players.findAll().list();
        return Multi.createFrom().items(Response.status(Response.Status.OK)
                .entity(allPlayers).build());

    }

    //todo- team should not have more than 10players
    @Override
    public Uni<Response> addPlayerToTeam(Long playerId, Long teamId) {
        Players player = Players.findById(playerId);
        if (player == null) {
            return Uni.createFrom().item(Response.status(Response.Status.NOT_FOUND)
                    .entity("PLAYER NOT FOUND").build());
        } else if (player.getTeam() != null) {
            return Uni.createFrom().item(Response.status(Response.Status.CONFLICT)
                    .entity("PLAYER ALREADY IN A TEAM").build());
        }

        Team team1 = Team.findById(teamId);
        if (team1 == null || playerCount(teamId) >= 10) {
            return Uni.createFrom().item(Response.status(Response.Status.NOT_FOUND)
                    .entity("TEAM NOT FOUND").build());
        } else{
            player.setTeam(team1);
            player.persist();
            return Uni.createFrom().item(Response.status(Response.Status.OK)
                    .entity(player).build());
        }
    }

    @Override
    public Uni<Response> removePlayer(Long playerId) {
        Players player = Players.findById(playerId);
        if(player != null){
            player.delete();
            return Uni.createFrom().item(Response.status(Response.Status.OK)
                    .entity("PLAYER DELETED").build());
        }else{
            return Uni.createFrom().item(Response.status(Response.Status.NOT_FOUND)
                    .entity("PLAYER NOT FOUND").build());
        }
    }


    private Long playerCount(Long teamId){
        return Players.find("team_id", teamId).count();
    }
}

