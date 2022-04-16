package org.esovisco.ligaflanek.services;

import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

//    UserRepository repository;
//    UserService service;
//
//    @BeforeEach
//    void before(){
//        repository = Mockito.mock(UserRepository.class);
//        service = new UserService(repository);
//    }
//
//    @Test
//    void getUserByNameUserExistsReturnsUser(){
//        String userName = "TestUser";
//        UserAccount user = new UserAccount(1L, userName, "pass", ApplicationUserRole.USER);
//
//        doReturn(Optional.of(user)).when(repository).findByName(userName);
//        assertThat(service.getUserByName(userName)).isEqualTo(user);
//    }
//
//    @Test
//    void getUserByNameUserNotExistsThrowsIllegalArgumentException(){
//        doReturn(Optional.empty()).when(repository).findByName(any(String.class));
//        assertThatThrownBy(() -> service.getUserByName("User")).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void getAllUsersReturnsListOfAllUsers(){
//        List<UserAccount> users = List.of(new UserAccount(1L, "User1", "passw", ApplicationUserRole.USER),
//                new UserAccount(2L, "User2", "passw", ApplicationUserRole.USER));
//
//        doReturn(users).when(repository).findAll();;
//
//        assertThat(service.getAllUsers()).isEqualTo(users);
//    }
//
//    @Test
//    void addUserAllGoodAddsUser(){
//        UserAccount user = new UserAccount(1L, "User", "passw", ApplicationUserRole.USER);
//
//        doReturn(user).when(repository).save(user);
//
//        assertDoesNotThrow(() -> service.addUser(user));
//    }
//
//    @Test
//    void addUserNameTakenThrowsIllegalArgumentException(){
//        doThrow(IllegalArgumentException.class).when(repository).save(any(UserAccount.class));
//        assertThatThrownBy(() -> service.addUser(new UserAccount())).isInstanceOf(IllegalArgumentException.class);
//    }


}