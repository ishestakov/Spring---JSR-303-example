package com.test.validation.constraints.validators;

import com.test.validation.constraints.ValidCurrency;
import com.test.validation.domain.Currency;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by illia on 3/2/14.
 */
public interface CurrencyValidator extends ConstraintValidator<ValidCurrency, Currency>{

}
