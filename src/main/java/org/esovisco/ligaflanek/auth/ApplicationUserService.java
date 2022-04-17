package org.esovisco.ligaflanek.auth;

import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;

    public ApplicationUserService(@Qualifier("psql") ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao.selectApplicationUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name "+username+" was not found!"));
    }

    public void createUser(ApplicationUser user){
        try {
            applicationUserDao.addUser(user);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Username taken!");
        }

    }

    public List<ApplicationUser> getAllUsers(){
        return applicationUserDao.getAllUsers();
    }

    public ApplicationUser getUserById(Long id){
        return applicationUserDao.getUserById(id);  //TODO try catch
    }

    public void updateUserRole(Long id, ApplicationUserRole role){
        applicationUserDao.updateUserRole(applicationUserDao.getUserById(id), role);
    }

    public void deleteUser(Long id) {
        try {
            applicationUserDao.deleteUserById(id);
        }
        catch (IllegalArgumentException e){
            System.err.println("Tried to delete user that doesn't exist (id="+id+")");
        }
    }
}
