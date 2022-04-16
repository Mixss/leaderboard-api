package org.esovisco.ligaflanek.services;

import org.esovisco.ligaflanek.commands.AddUserCommand;
import org.esovisco.ligaflanek.domain.User;
import org.esovisco.ligaflanek.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserByName(String name){
        return new User();
    }

    public List<User> getAllUsers() {
        return List.of(new User());
    }

    public void addUser(User user){

    }
}
