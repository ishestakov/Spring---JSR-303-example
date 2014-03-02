package com.test.validation.constraints.validators.impl;

import com.google.common.collect.Lists;
import com.test.validation.constraints.ValidCurrency;
import com.test.validation.constraints.validators.CurrencyValidator;
import com.test.validation.domain.Currency;

import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by illia on 3/2/14.
 */
public class CurrencyConstraintValidator implements CurrencyValidator {

    private ValidCurrency constraint;

    @Override
    public void initialize(ValidCurrency constraintAnnotation) {
        this.constraint = constraintAnnotation;
    }

    @Override
    public boolean isValid(Currency value, ConstraintValidatorContext context) {
        List<Currency> validCurrencyList = Lists.newArrayList(constraint.includeCurrencies());
        List<Currency> invalidCurrencyList = Lists.newArrayList(constraint.excludeCurrencies());
        boolean valid = true;
        if (!validCurrencyList.isEmpty()) {
            valid &= validCurrencyList.contains(value);
        }
        if (!invalidCurrencyList.isEmpty()) {
            valid &= !invalidCurrencyList.contains(value);
        }
        return valid;
    }
}
