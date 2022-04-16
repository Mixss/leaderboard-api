package org.esovisco.ligaflanek.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.esovisco.ligaflanek.security.ApplicationUserPermission;
import org.esovisco.ligaflanek.security.ApplicationUserRole;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

@Setter
@AllArgsConstructor
@Entity
@Table(name = "users")
@NoArgsConstructor
public class ApplicationUser implements UserDetails {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long Id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull

    @NotNull
    private ApplicationUserRole role;

    @NotNull
    private boolean isAccountNonExpired;
    @NotNull
    private boolean isAccountNonLocked;
    @NotNull
    private boolean isCredentialNonExpired;
    @NotNull
    private boolean isEnabled;

    public ApplicationUser(String username, String password, ApplicationUserRole role, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialNonExpired, boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialNonExpired = isCredentialNonExpired;
        this.isEnabled = isEnabled;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getGrantedAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
