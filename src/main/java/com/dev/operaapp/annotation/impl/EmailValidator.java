package com.dev.operaapp.annotation.impl;

import com.dev.operaapp.annotation.EmailConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    public static final String REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && email.matches(REGEX);
    }
}
