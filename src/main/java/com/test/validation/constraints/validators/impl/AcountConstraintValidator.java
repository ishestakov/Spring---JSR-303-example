package com.test.validation.constraints.validators.impl;

import com.test.validation.constraints.ValidAccount;
import com.test.validation.constraints.validators.AccountValidator;
import com.test.validation.domain.Account;
import com.test.validation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidatorContext;

/**
 * Created by illia on 3/3/14.
 */
public class AcountConstraintValidator implements AccountValidator {

    @Autowired
    private AccountService service;

    @Override
    public void initialize(ValidAccount constraintAnnotation) {

    }

    @Override
    public boolean isValid(Account value, ConstraintValidatorContext context) {
        return service.checkIfExist(value.getAccountNumber());
    }
}
