package org.esovisco.ligaflanek.auth;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

    void addUser(ApplicationUser user);
}
