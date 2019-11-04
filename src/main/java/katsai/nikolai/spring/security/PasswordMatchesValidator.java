package katsai.nikolai.spring.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import katsai.nikolai.spring.dto.UserRegistrationDto;
import katsai.nikolai.spring.security.annotations.PasswordMatches;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserRegistrationDto user = (UserRegistrationDto) obj;
        return user.getPassword().equals(user.getRepeatPassword());
    }
}