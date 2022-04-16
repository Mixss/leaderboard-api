package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.domain.Team;
import org.esovisco.ligaflanek.services.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TeamControllerTest {

    TeamService teamService;
    List<Team> teamList;

    @BeforeEach
    public void before(){
        teamService = Mockito.mock(TeamService.class);
        teamList = List.of(new Team(1L, "Team1", 0), new Team(2L, "Team2", 0));
    }

    @Test
    public void addPointsSubmitAddsPoints() {
        Mockito.doReturn(teamList).when(teamService).getTeams();

    }

}