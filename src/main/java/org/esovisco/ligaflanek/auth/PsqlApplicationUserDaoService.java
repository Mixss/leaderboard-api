package org.esovisco.ligaflanek.auth;

import org.esovisco.ligaflanek.repositories.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public List<ApplicationUser> getAllUsers(){
        return repository.findAll();
    }

    @Override
    public ApplicationUser getUserById(Long id) {
        Optional<ApplicationUser> optionalUser = repository.findById(id);
        if(optionalUser.isEmpty()){
            throw new IllegalArgumentException("User not found!");
        }
        return optionalUser.get();
    }
}
