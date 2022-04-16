package org.esovisco.ligaflanek.repositories;

import org.esovisco.ligaflanek.auth.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    @Query("SELECT u FROM ApplicationUser u WHERE u.username = ?1")
    Optional<ApplicationUser> findByName(String name);
}
