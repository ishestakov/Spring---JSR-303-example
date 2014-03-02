package com.test.validation.constraints;

import com.test.validation.constraints.validators.BeneficiaryConsistenceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by illia on 3/2/14.
 */
@Target(value = {TYPE})
@Constraint(validatedBy = {BeneficiaryConsistenceValidator.class})
@Retention(RUNTIME)
@Documented
public @interface BeneficiaryConsistance {
    String message() default "{com.test.validation.constraints.beneficiary.inconsistence.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
