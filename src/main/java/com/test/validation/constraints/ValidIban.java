package com.test.validation.constraints;

import com.test.validation.constraints.validators.IbanValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by illia on 3/2/14.
 */
@Target(value = {METHOD, FIELD, ANNOTATION_TYPE})
@Constraint(validatedBy = {IbanValidator.class})
@Retention(RUNTIME)
public @interface ValidIban {
    String message() default "{com.test.validation.constraints.iban.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
