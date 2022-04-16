package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.commands.AddPointsCommand;
import org.esovisco.ligaflanek.commands.AddTeamCommand;
import org.esovisco.ligaflanek.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    private final TeamService service;

    public ViewController(TeamService service) {
        this.service = service;
    }

    @RequestMapping({"/"})
    public String teams(Model model) {
        model.addAttribute("teams", service.getTeams());
        return "list_teams";
    }


    @RequestMapping("/points/add")
    public String addPoints(Model model) {
        model.addAttribute("teams", service.getTeams());
        model.addAttribute("addPointsCommand", new AddPointsCommand());
        return "add_points";
    }

    @RequestMapping("/teams/add")
    public String addNewTeam(Model model) {
        model.addAttribute("addTeamCommand", new AddTeamCommand());
        return "add_team";
    }
}
