package org.esovisco.ligaflanek.bootstrap;

import org.esovisco.ligaflanek.auth.ApplicationUser;
import org.esovisco.ligaflanek.auth.ApplicationUserService;
import org.esovisco.ligaflanek.domain.Team;
import org.esovisco.ligaflanek.services.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static org.esovisco.ligaflanek.security.ApplicationUserRole.ADMIN;
import static org.esovisco.ligaflanek.security.ApplicationUserRole.USER;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TeamService teamService;
    private final ApplicationUserService applicationUserService;
    private final PasswordEncoder passwordEncoder;

    public Bootstrap(TeamService teamService, ApplicationUserService applicationUserService, PasswordEncoder passwordEncoder) {
        this.teamService = teamService;
        this.applicationUserService = applicationUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap is working...");
        teamService.addTeam(new Team("Esovisco"));
        teamService.addTeam(new Team("Apki Flanki"));

        applicationUserService.createUser(new ApplicationUser(
                "admin",
                passwordEncoder.encode("admin"),
                ADMIN,
                true, true, true, true
        ));
        applicationUserService.createUser(new ApplicationUser(
                "user",
                passwordEncoder.encode("user"),
                USER,
                true, true, true, true
        ));
    }
}
