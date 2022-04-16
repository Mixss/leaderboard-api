package org.esovisco.ligaflanek.bootstrap;

import org.esovisco.ligaflanek.domain.Team;
import org.esovisco.ligaflanek.services.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TeamService teamService;

    public Bootstrap(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap is working...");
        teamService.addTeam(new Team("Esovisco"));
        teamService.addTeam(new Team("Apki Flanki"));

    }
}
