package org.esovisco.ligaflanek.services;

import org.esovisco.ligaflanek.commands.AddUserCommand;
import org.esovisco.ligaflanek.domain.User;
import org.esovisco.ligaflanek.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserByName(String name) throws IllegalArgumentException{
        Optional<User> optionalUser = repository.findByName(name);
        if(optionalUser.isEmpty()) {
            throw new IllegalArgumentException("Did not find user with name "+name);
        }
        return optionalUser.get();
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void addUser(User user){
        Optional<User> optionalUserToFind = repository.findByName(user.getName());
        if(optionalUserToFind.isPresent()) {
            throw new IllegalArgumentException("User with name "+user.getName()+ " already exists!");
        }
        repository.save(user);
    }
}
