package com.test.validation.constraints.validators;

import com.test.validation.constraints.ValidAccount;
import com.test.validation.domain.Account;

import javax.validation.ConstraintValidator;

/**
 * Created by illia on 3/3/14.
 */
public interface AccountValidator extends ConstraintValidator<ValidAccount, Account> {
}
