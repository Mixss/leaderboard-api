package org.esovisco.ligaflanek.auth;

import org.esovisco.ligaflanek.security.ApplicationUserRole;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

    void addUser(ApplicationUser user);

    List<ApplicationUser> getAllUsers();

    ApplicationUser getUserById(Long id);

    @Transactional
    void updateUserRole(ApplicationUser user, ApplicationUserRole role);

    void deleteUserById(Long id) throws IllegalArgumentException;
}
