package org.esovisco.ligaflanek.controllers;

import org.esovisco.ligaflanek.auth.ApplicationUser;
import org.esovisco.ligaflanek.auth.ApplicationUserService;
import org.esovisco.ligaflanek.commands.SignUpCommand;
import org.esovisco.ligaflanek.commands.UpdateRoleCommand;
import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/management/users/{id}/update_role")
    @PreAuthorize("hasAuthority('users:write')")
    public String updateUserRole(@ModelAttribute("updateRoleCommand") UpdateRoleCommand updateRoleCommand, @PathVariable("id") Long id){
        ApplicationUser applicationUser;
        try {
            applicationUser = service.getUserById(id);
        } catch (Exception e){
            return "redirect:/management/users";
        }
        service.updateUserRole(id, updateRoleCommand.getSelectedRole());
        return "redirect:/management/users/"+id;
    }

    @PostMapping("/management/users/{id}/delete")
    @PreAuthorize("hasAuthority('users:write')")
    public String deleteUser(@PathVariable("id") Long id){
        ApplicationUser applicationUser;
        try {
            applicationUser = service.getUserById(id);
        } catch (Exception e){
            return "redirect:/management/users";
        }
        service.deleteUser(id);
        return "redirect:/management/users";
    }

}
