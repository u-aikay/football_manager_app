package com.fm22.services.seviceImpl;

import com.fm22.dtos.TeamDto;
import com.fm22.models.Team;
import com.fm22.services.TeamService;
import io.smallrye.common.constraint.NotNull;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@ApplicationScoped
public class TeamServiceImpl implements TeamService {

    @Override
    public Response createTeam(@NotNull TeamDto teamDto) {

        Team team = Team.find("teamName", teamDto.getTeamName()).firstResult();
        if (team != null) {
            return Response.status(Response.Status.CONFLICT).entity("TEAM ALREADY EXIST").build();
        }
        Team newTeam = Team.builder()
                .teamName(teamDto.getTeamName())
                .build();
        newTeam.persist();

        return Response.status(Response.Status.CREATED).entity(newTeam).build();
    }

    @Override
    public Response getAllTeams() {
        List<Team> allTeams = Team.findAll().list();
        return Response.ok(allTeams).build();
    }

    @Override
    public Response deleteTeam(String teamName) {

        Team team = Team.find("teamName", teamName).firstResult();
        if (team == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("TEAM NOT FOUND").build();
        }
        team.delete();
        return Response.status(Response.Status.OK).entity(teamName + " deleted from Database").build();
    }
}
