package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.auth.ApplicationUserService;
import org.esovisco.ligaflanek.commands.AddPointsCommand;
import org.esovisco.ligaflanek.commands.AddTeamCommand;
import org.esovisco.ligaflanek.commands.SignUpCommand;
import org.esovisco.ligaflanek.services.TeamService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    private final TeamService teamService;
    private final ApplicationUserService applicationUserService;

    public ViewController(TeamService service, ApplicationUserService applicationUserService) {
        this.teamService = service;
        this.applicationUserService = applicationUserService;
    }

    @RequestMapping({"/"})
    public String teams(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        return "list_teams";
    }


    @RequestMapping("/points/add")
    @PreAuthorize("hasAuthority('points:write')")
    public String addPoints(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        model.addAttribute("addPointsCommand", new AddPointsCommand());
        return "add_points";
    }

    @RequestMapping("/teams/add")
    @PreAuthorize("hasAuthority('team:write')")
    public String addNewTeam(Model model) {
        model.addAttribute("addTeamCommand", new AddTeamCommand());
        return "add_team";
    }

    @RequestMapping("register")
    public String register(Model model){
        model.addAttribute("signUpCommand", new SignUpCommand());
        return "register";
    }

    @RequestMapping("/management/users")
    @PreAuthorize("hasAuthority('users:read')")
    public String listUsers(Model model){
        model.addAttribute("users", applicationUserService.getAllUsers());
        return "user_management";
    }

    @RequestMapping("/management/users/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public String manageUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", applicationUserService.getUserById(id));
        return "user_details";
    }
}
