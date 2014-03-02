package com.test.validation.constraints;

import com.test.validation.constraints.validators.CurrencyValidator;
import com.test.validation.constraints.validators.SwiftValidator;
import com.test.validation.domain.Currency;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The basic currency validator interface.
 */
@Target(value = {METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CurrencyValidator.class)
public @interface ValidCurrency {
    String message() default "{com.test.validation.constraints.currency.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Currency[] includeCurrencies() default {};
    Currency[] excludeCurrencies() default {};
}
