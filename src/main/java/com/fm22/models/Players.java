package com.fm22.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
//import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Players extends PanacheEntity {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String position;
    private int number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}
