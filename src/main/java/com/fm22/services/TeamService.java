package com.fm22.services;

import com.fm22.dtos.TeamDto;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;


public interface TeamService {
    Uni<Response> createTeam(TeamDto teamDto);
    Multi<Response> getAllTeams();
    Uni<Response> deleteTeam(String teamName);
}
