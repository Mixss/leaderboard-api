package org.esovisco.ligaflanek.auth;

import org.esovisco.ligaflanek.repositories.ApplicationUserRepository;
import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
    public void addUser(ApplicationUser user) throws IllegalArgumentException {
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
    public ApplicationUser getUserById(Long id) throws IllegalArgumentException{
        Optional<ApplicationUser> optionalUser = repository.findById(id);
        if(optionalUser.isEmpty()){
            throw new IllegalArgumentException("User not found!");
        }
        return optionalUser.get();
    }

    @Override
    @Transactional
    public void updateUserRole(ApplicationUser user, ApplicationUserRole role) {
        user.setRole(role);
    }

    @Override
    public void deleteUserById(Long id) throws IllegalArgumentException{
        try {
            repository.deleteById(id);
        } catch (Exception e){
            throw new IllegalArgumentException("User not found!");
        }

    }
}
