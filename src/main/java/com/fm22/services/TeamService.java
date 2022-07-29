package com.fm22.services;

import com.fm22.dtos.TeamDto;
import javax.ws.rs.core.Response;

public interface TeamService {
    Response createTeam(TeamDto teamDto);
    Response getAllTeams();
    Response deleteTeam(String teamName);
}
