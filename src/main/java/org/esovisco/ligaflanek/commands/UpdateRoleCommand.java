package org.esovisco.ligaflanek.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.esovisco.ligaflanek.security.ApplicationUserRole;

import javax.persistence.GeneratedValue;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateRoleCommand {

    private ApplicationUserRole selectedRole;
}
