package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

//    UserService service;
//    UserController controller;
//
//    @BeforeEach
//    void before(){
//        service = Mockito.mock(UserService.class);
//        controller = new UserController(service);
//    }
//
//    @Test
//    void getAllUsersReturnsListOfUsers() {
//        List<UserAccount> users = List.of(new UserAccount(1L, "User1", "passw", ApplicationUserRole.USER),
//                new UserAccount(2L, "User2", "passw", ApplicationUserRole.USER));
//
//        doReturn(users).when(service).getAllUsers();
//
//        assertThat(controller.getAllUsers()).isEqualTo(users);
//    }
//
//    @Test
//    void getUserByNameUserExistsReturnsUser() {
//        UserAccount user = new UserAccount(1L, "User", "passw", ApplicationUserRole.USER);
//        doReturn(user).when(service).getUserByName(user.getName());
//
//        assertThat(controller.getUserByName(user.getName())).isEqualTo(user);
//    }
//
//    @Test
//    void getUserByNameUserNotExistsThrowsIllegalArgumentException() {
//        doThrow(IllegalArgumentException.class).when(service).getUserByName(any());
//        assertThatThrownBy(() -> controller.getUserByName("User")).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void createUserNameFreeCreatesNewUser() {
//        doNothing().when(service).addUser(any());
//        assertDoesNotThrow(() -> controller.createUser(new UserAccount()));
//    }
//
//    @Test
//    void createUserNameTakenThrowsIllegalArgumentException() {
//        doThrow(IllegalArgumentException.class).when(service).addUser(any());
//        assertThatThrownBy(() -> controller.createUser(new UserAccount())).isInstanceOf(IllegalArgumentException.class);
//    }
}