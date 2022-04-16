package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.commands.AddPointsCommand;
import org.esovisco.ligaflanek.commands.AddTeamCommand;
import org.esovisco.ligaflanek.domain.Team;
import org.esovisco.ligaflanek.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class TeamController {

    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @RequestMapping({"/teams"})
    public String teams(Model model) {
        model.addAttribute("teams", service.getTeams());
        return "list_teams";
    }


    @RequestMapping("/add")
    public String addPoints(Model model) {
        model.addAttribute("teams", service.getTeams());
        model.addAttribute("addPointsCommand", new AddPointsCommand());
        return "add_points";
    }

    @PostMapping("/add")
    public String addPointsSubmit(@Valid AddPointsCommand addPointsCommand, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("teams", service.getTeams());
            model.addAttribute("error_message", "Podane wartości są nieprawidłowe!");
            return "add_points";
        }
        service.addPointsCommand(addPointsCommand);
        return "redirect:/teams";
    }

    @RequestMapping("/teams/add")
    public String addNewTeam(Model model) {
        model.addAttribute("addTeamCommand", new AddTeamCommand());
        return "add_team";
    }

    @PostMapping("/teams/add")
    public String addTeamLogin(@Valid AddTeamCommand addTeamCommand, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("error_message", "Nazwa zajęta lub nieprawidłowa!");
            return "add_points";
        }
        service.addTeam(new Team(addTeamCommand.getTeamName()));
        return "redirect:/teams";
    }
}
