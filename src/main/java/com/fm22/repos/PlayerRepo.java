package com.fm22.repos;

import com.fm22.models.Players;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
//import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerRepo implements PanacheRepository<Players> {

}
