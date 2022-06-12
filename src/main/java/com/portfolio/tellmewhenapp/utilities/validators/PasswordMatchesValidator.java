package com.portfolio.tellmewhenapp.utilities.validators;

import com.portfolio.tellmewhenapp.utilities.annotations.PasswordMatches;
import com.portfolio.tellmewhenapp.user.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        //no-op, does nothing
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
