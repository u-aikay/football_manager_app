package com.fm22.services;

import com.fm22.dtos.PlayerDto;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import javax.ws.rs.core.Response;


public interface PlayerService {
    Uni<Response> createPlayer(PlayerDto playerDto);
    Uni<Response> getPlayer(Long id);
    Multi<Response> getAllPlayers();
    Uni<Response> addPlayerToTeam(Long playerId, Long teamId);
    Uni<Response> removePlayer(Long playerId);
}
