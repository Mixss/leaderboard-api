package org.esovisco.ligaflanek.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddPointsCommand{

    private String selectedTeam;
    @NotNull
    private Integer pointsToAdd;
}
