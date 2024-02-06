package org.example.bigevent.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.bigevent.anno.State;

public class StateValidation implements ConstraintValidator<State, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        return s.equals("已发布") || s.equals("草稿");
    }
}
