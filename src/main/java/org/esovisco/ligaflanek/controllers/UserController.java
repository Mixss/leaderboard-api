package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.auth.ApplicationUser;
import org.esovisco.ligaflanek.auth.ApplicationUserService;
import org.esovisco.ligaflanek.commands.SignUpCommand;
import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    // TODO add user role management

    private final ApplicationUserService service;
    private final PasswordEncoder passwordEncoder;

    public UserController(ApplicationUserService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("signUpCommand") SignUpCommand signUpCommand, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "register";
        }
        try {
            service.createUser(new ApplicationUser(
                    signUpCommand.getUsername(),
                    passwordEncoder.encode(signUpCommand.getPassword()),
                    ApplicationUserRole.USER,
                    true, true, true, true
                    ));
        } catch (Exception e){
            model.addAttribute("error_message", "Username taken!");
            return "register";
        }


        return "redirect:/";
    }

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
