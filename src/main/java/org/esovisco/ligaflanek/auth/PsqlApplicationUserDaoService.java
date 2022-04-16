package org.esovisco.ligaflanek.auth;

import org.esovisco.ligaflanek.repositories.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("psql")
public class PsqlApplicationUserDaoService implements ApplicationUserDao {

    private final ApplicationUserRepository repository;

    public PsqlApplicationUserDaoService(ApplicationUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return repository.findByName(username);
    }

    @Override
    public void addUser(ApplicationUser user) {
        Optional<ApplicationUser> optionalUser = repository.findByName(user.getUsername());
        if(optionalUser.isPresent()){
            throw new IllegalArgumentException("Username taken!");
        }
        repository.save(user);
    }
}
