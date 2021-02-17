package com.dev.cinema.annotation.impl;

import com.dev.cinema.annotation.EmailConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    public static final String REGEX = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\."
            + "[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && email.matches(REGEX);
    }
}
