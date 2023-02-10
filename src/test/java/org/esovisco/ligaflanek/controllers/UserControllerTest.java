package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.auth.ApplicationUserService;
import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    ApplicationUserService service;
    UserController controller;
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void before(){
        service = Mockito.mock(ApplicationUserService.class);
        passwordEncoder = Mockito.mock(PasswordEncoder.class);
        controller = new UserController(service, passwordEncoder);
    }


}