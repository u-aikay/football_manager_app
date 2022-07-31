package com.fm22.dtos;

import io.smallrye.common.constraint.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class PlayerDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String position;
    @NotNull
    private int number;
}
