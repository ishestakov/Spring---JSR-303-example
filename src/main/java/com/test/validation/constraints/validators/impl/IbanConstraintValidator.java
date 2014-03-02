package com.test.validation.constraints.validators.impl;

import com.test.validation.constraints.ValidIban;
import com.test.validation.constraints.validators.IbanValidator;
import org.iban4j.IbanFormatException;
import org.iban4j.IbanUtil;

import javax.validation.ConstraintValidatorContext;

/**
 * Created by illia on 3/2/14.
 */
public class IbanConstraintValidator implements IbanValidator {

    @Override
    public void initialize(ValidIban constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            IbanUtil.validate(value);
        } catch (IbanFormatException e) {
            return false;
        }
        return true;
    }
}
