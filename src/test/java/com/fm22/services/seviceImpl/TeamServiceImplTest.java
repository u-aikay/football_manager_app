package com.fm22.services.seviceImpl;

import com.fm22.dtos.TeamDto;
import com.fm22.models.Team;
import com.fm22.services.TeamService;
import io.quarkus.test.common.QuarkusTestResource;
import io.restassured.specification.RequestSpecification;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.quarkus.test.h2.H2DatabaseTestResource;
import org.mockito.InjectMocks;
import javax.inject.Inject;
import javax.ws.rs.core.Response;


@QuarkusTestResource(H2DatabaseTestResource.class)
@Tag("UnitTest")
public class TeamServiceImplTest {

    @InjectMocks
    TeamService teamService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void createTeam() {
//        TeamDto teamDto = new TeamDto();
//        teamDto.setTeamName("Test-fc");
//        Uni<Response> responseUni = teamService.createTeam(teamDto);
//        Assertions.assertEquals(Response.Status.CREATED, responseUni);

    }

    @Test
    void getAllTeams() {
    }

    @Test
    void deleteTeam() {
    }
}