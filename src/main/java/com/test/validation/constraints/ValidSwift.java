package com.test.validation.constraints;

import com.test.validation.constraints.validators.SwiftValidator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The validator interface for the SWIFT codes.
 */
@Target(value = {METHOD, FIELD, ANNOTATION_TYPE})
@Constraint(validatedBy = SwiftValidator.class)
@Retention(RUNTIME)
@Documented
public @interface ValidSwift {
    String message() default "{com.test.validation.constraints.swift.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
