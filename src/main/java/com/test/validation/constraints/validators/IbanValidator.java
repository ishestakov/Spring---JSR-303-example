package com.test.validation.constraints.validators;

import com.test.validation.constraints.ValidIban;

import javax.validation.ConstraintValidator;

/**
 * Created by illia on 3/2/14.
 */
public interface IbanValidator extends ConstraintValidator<ValidIban, String> {
}
