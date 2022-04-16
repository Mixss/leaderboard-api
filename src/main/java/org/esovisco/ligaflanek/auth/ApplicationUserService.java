package org.esovisco.ligaflanek.auth;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        applicationUserDao.addUser(user);
    }
}
