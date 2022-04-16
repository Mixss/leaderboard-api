package org.esovisco.ligaflanek.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    private final UserService service;
//
//    public UserController(UserService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/find")
//    @PreAuthorize("hasAuthority('users:read')")
//    public List<UserAccount> getAllUsers() {
//        return service.getAllUsers();
//    }
//
//    @GetMapping(path = "/find/{name}")
//    @PreAuthorize("hasAuthority('users:read')")
//    public UserAccount getUserByName(@PathVariable("name") String name){
//        try {
//            UserAccount user = service.getUserByName(name);
//            return user;
//        } catch (IllegalArgumentException e){
//            throw new IllegalArgumentException("Did not find this user!");
//        }
//    }
//
//    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('users:write')")
//    public void createUser(@RequestBody UserAccount user){
//        try {
//            service.addUser(user);
//        } catch (IllegalArgumentException e){
//            throw new IllegalArgumentException("Couldn't create this user!");
//        }
//    }
}
