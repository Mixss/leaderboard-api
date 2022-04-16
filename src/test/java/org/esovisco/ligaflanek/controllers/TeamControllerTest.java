package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.commands.AddPointsCommand;
import org.esovisco.ligaflanek.commands.AddTeamCommand;
import org.esovisco.ligaflanek.domain.Team;
import org.esovisco.ligaflanek.services.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TeamControllerTest {

    TeamService teamService;
    List<Team> teamList;
    TeamController teamController;
    BindingResult bindingResult;
    Model model;

    @BeforeEach
    public void before(){
        teamService = Mockito.mock(TeamService.class);
        teamList = List.of(new Team(1L, "Team1", 0), new Team(2L, "Team2", 0));
        teamController = new TeamController(teamService);
        bindingResult = Mockito.mock(BindingResult.class);
        model = Mockito.mock(Model.class);
    }

    @Test
    public void addTeamLoginNameOccupiedReturnsTheSameViewWithErrorInModel() {
        Mockito.doThrow(IllegalArgumentException.class).when(teamService).addTeam(any(Team.class));
        Mockito.doReturn(false).when(bindingResult).hasErrors();
        assertThat(teamController.addTeamLogin(new AddTeamCommand("Team 1"), bindingResult, model)).isEqualTo("add_points");
    }

    @Test void addTeamLoginBadNameReturnsTheSameViewWithErrorInModel(){
        Mockito.doReturn(true).when(bindingResult).hasErrors();
        assertThat(teamController.addTeamLogin(new AddTeamCommand("Team 1"), bindingResult, model)).isEqualTo("add_points");
    }

    @Test
    void addTeamLoginAllGoodRedirectsToMainPage(){
        Mockito.doReturn(false).when(bindingResult).hasErrors();
        assertThat(teamController.addTeamLogin(new AddTeamCommand("Team 1"), bindingResult, model)).isEqualTo("redirect:/");
    }

    @Test
    void addPointsSubmitAllGoodRedirectsToMainPage(){
        Mockito.doReturn(false).when(bindingResult).hasErrors();
        assertThat(teamController.addPointsSubmit(new AddPointsCommand(), bindingResult, model)).isEqualTo("redirect:/");
    }

    @Test
    void addPointsSubmitWrongDataReturnsTheSameViewWithErrorInModel(){
        Mockito.doReturn(true).when(bindingResult).hasErrors();
        assertThat(teamController.addPointsSubmit(new AddPointsCommand(), bindingResult, model)).isEqualTo("add_points");
    }

    @Test
    void addPointsSubmitTeamNotFoundReturnsTheSameViewWithErrorInModel(){
        Mockito.doReturn(false).when(bindingResult).hasErrors();
        Mockito.doThrow(IllegalArgumentException.class).when(teamService).addPointsCommand(any(AddPointsCommand.class));
        assertThat(teamController.addPointsSubmit(new AddPointsCommand(), bindingResult, model)).isEqualTo("add_points");
    }

}