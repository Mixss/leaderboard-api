package org.esovisco.ligaflanek.validators;

import org.esovisco.ligaflanek.commands.SignUpCommand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SignUpCommand signUpCommand = (SignUpCommand) o;
        return signUpCommand.getPassword().equals(signUpCommand.getPassword2());
    }
}
