package com.dev.cinema.annotation.impl;

import com.dev.cinema.annotation.PasswordConstraint;
import com.dev.cinema.model.dto.authentication.AuthenticationRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint,
        AuthenticationRequestDto> {
    private String password;
    private String repeatPassword;

    @Override
    public void initialize(PasswordConstraint constraintAnnotation) {
        this.password = constraintAnnotation.field();
        this.repeatPassword = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(AuthenticationRequestDto authRequestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(authRequestDto)
                .getPropertyValue(password);
        Object fieldMatchValue = new BeanWrapperImpl(authRequestDto)
                .getPropertyValue(repeatPassword);
        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}
