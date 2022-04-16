package org.esovisco.ligaflanek.security;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;


public enum ApplicationUserPermission {
    TEAM_WRITE("team:write"),
    TEAM_READ("team:read"),
    POINTS_WRITE("points:write"),
    USERS_READ("users:read"),
    USERS_WRITE("users:write");

    @Getter
    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
}
