package org.esovisco.ligaflanek.services;

import org.esovisco.ligaflanek.commands.AddPointsCommand;
import org.esovisco.ligaflanek.domain.Team;
import org.esovisco.ligaflanek.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public List<Team> getTeams() {
        return repository.findAll();
    }

    public void addTeam(Team team) throws IllegalArgumentException{
        Optional<Team> teamOptional = repository.getTeamByName(team.getName());
        if(teamOptional.isPresent()) {
            throw new IllegalArgumentException("Team with name '"+team.getName()+"' already exists!");
        }
        repository.save(team);
    }

    @Transactional
    public void addPointsCommand(AddPointsCommand addPointsCommand) {
        Optional<Team> teamOptional = repository.getTeamByName(addPointsCommand.getSelectedTeam());
        if(teamOptional.isEmpty()){
            throw new IllegalArgumentException("This team wasn't found.");
        }
        Team team = teamOptional.get();
        team.setPoints(team.getPoints()+addPointsCommand.getPointsToAdd());
    }
}
