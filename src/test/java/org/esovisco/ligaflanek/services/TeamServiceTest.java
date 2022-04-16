package org.esovisco.ligaflanek.services;

import org.esovisco.ligaflanek.domain.Team;
import org.esovisco.ligaflanek.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class TeamServiceTest {

    TeamService service;
    TeamRepository teamRepository;
    List<Team> teamList;

    @BeforeEach
    public void before(){
        teamRepository = Mockito.mock(TeamRepository.class);
        teamList = List.of(new Team(1L, "Team1", 0), new Team(2L, "Team2", 0));
        service = new TeamService(teamRepository);
    }

    @Test
    void getTeamsReturnsListOfTeams() {
        Mockito.doReturn(teamList).when(teamRepository).findAll();
        assertThat(service.getTeams()).isEqualTo(teamList);
    }

    @Test
    void addTeamNameOccupiedThrowsIllegalArgumentException() {
        String teamName = "New Team";
        Team teamToAdd = new Team(10L, teamName, 0);

        Mockito.doReturn(Optional.of(teamToAdd)).when(teamRepository).getTeamByName(teamName);

        assertThatThrownBy(() -> service.addTeam(teamToAdd)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addTeamNameNotOccupiedAddsTeam() {
        String teamName = "New Team";
        Team teamToAdd = new Team(10L, teamName, 0);
        Mockito.doReturn(Optional.empty()).when(teamRepository).getTeamByName(teamName);
        Mockito.doReturn(List.of(teamToAdd)).when(teamRepository).findAll();
        service.addTeam(teamToAdd);
        assertThat(service.getTeams()).isEqualTo(List.of(teamToAdd));
    }
}