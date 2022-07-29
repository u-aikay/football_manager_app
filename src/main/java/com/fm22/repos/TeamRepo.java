package com.fm22.repos;

import com.fm22.models.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamRepo implements PanacheRepository<Team> {

    public Team findByName(String teamName) {
        return find("teamName", teamName).firstResult();
    }
}
