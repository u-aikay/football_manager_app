package com.fm22.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
//import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team extends PanacheEntity {
    @NotNull
    @Column(name = "team_name")
    private String teamName;
//    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
//    private Set<Players> players;
}

