package org.example.bigevent.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.bigevent.validation.StateValidation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {StateValidation.class}
)
public @interface State {

    String message() default "State 只能是已发布或者草稿";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};}
