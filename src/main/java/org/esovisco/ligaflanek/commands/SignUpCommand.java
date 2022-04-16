package org.esovisco.ligaflanek.commands;

import lombok.*;
import org.esovisco.ligaflanek.validators.PasswordMatches;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PasswordMatches
public class SignUpCommand {

    @NotEmpty
    @Size(min=3, max=32)
    private String username;

    @NotEmpty
    @Size(min = 8, max=127)
    private String password;
    private String password2;
}
