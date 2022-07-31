package com.fm22.dtos;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;


@Data
@Getter
@Setter
public class TeamDto {
    @NotNull
    @Column(name = "team_name")
    private String teamName;

}
