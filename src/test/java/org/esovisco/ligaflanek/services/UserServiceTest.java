package org.esovisco.ligaflanek.services;

import org.esovisco.ligaflanek.domain.User;
import org.esovisco.ligaflanek.repositories.UserRepository;
import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    UserRepository repository;
    UserService service;

    @BeforeEach
    void before(){
        repository = Mockito.mock(UserRepository.class);
        service = new UserService(repository);
    }

    @Test
    void getUserByNameUserExistsReturnsUser(){
        String userName = "TestUser";
        User user = new User(1L, userName, ApplicationUserRole.USER);

        doReturn(Optional.of(user)).when(repository).findByName(userName);
        assertThat(service.getUserByName(userName)).isEqualTo(user);
    }

    @Test
    void getUserByNameUserNotExistsThrowsIllegalArgumentException(){
        doReturn(Optional.empty()).when(repository).findByName(any(String.class));
        assertThatThrownBy(() -> service.getUserByName("User")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getAllUsersReturnsListOfAllUsers(){
        List<User> users = List.of(new User(1L, "User1", ApplicationUserRole.USER),
                new User(2L, "User2", ApplicationUserRole.USER));

        doReturn(users).when(repository).findAll();;

        assertThat(service.getAllUsers()).isEqualTo(users);
    }

    @Test
    void addUserAllGoodAddsUser(){
        User user = new User(1L, "User", ApplicationUserRole.USER);

        doReturn(user).when(repository).save(user);

        assertDoesNotThrow(() -> service.addUser(user));
    }

    @Test
    void addUserNameTakenThrowsIllegalArgumentException(){
        doThrow(IllegalArgumentException.class).when(repository).save(any(User.class));
        assertThatThrownBy(() -> service.addUser(new User())).isInstanceOf(IllegalArgumentException.class);
    }


}