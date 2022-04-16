package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.commands.AddPointsCommand;
import org.esovisco.ligaflanek.commands.AddTeamCommand;
import org.esovisco.ligaflanek.domain.Team;
import org.esovisco.ligaflanek.services.TeamService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class TeamController {

    //TODO show details of selected team

    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @PostMapping("/points/add")
    @PreAuthorize("hasAuthority('points:write')")
    public String addPointsSubmit(@Valid AddPointsCommand addPointsCommand, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("teams", service.getTeams());
            model.addAttribute("error_message", "Given values are wrong!");
            return "add_points";
        }
        try {
            service.addPointsCommand(addPointsCommand);
        }
        catch (IllegalArgumentException e){
            model.addAttribute("teams", service.getTeams());
            model.addAttribute("error_message", "This team does not exists!");
            return "add_points";
        }
        return "redirect:/";
    }

    @PostMapping("/teams/add")
    @PreAuthorize("hasAuthority('team:write')")
    public String addTeamLogin(@Valid AddTeamCommand addTeamCommand, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("error_message", "The name is invalid!");
            return "add_team";
        }
        try {
            service.addTeam(new Team(addTeamCommand.getTeamName()));
        }
        catch (IllegalArgumentException e) {
            model.addAttribute("error_message", "The name is already taken!");
            return "add_team";
        }
        return "redirect:/";
    }
}
