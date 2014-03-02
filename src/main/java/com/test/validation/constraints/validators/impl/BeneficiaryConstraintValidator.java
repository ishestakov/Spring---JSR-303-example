package com.test.validation.constraints.validators.impl;

import com.test.validation.constraints.BeneficiaryConsistance;
import com.test.validation.constraints.validators.BeneficiaryConsistenceValidator;
import com.test.validation.domain.BeneficiaryInfo;
import org.iban4j.Iban;

import javax.validation.ConstraintValidatorContext;

/**
 * Created by illia on 3/3/14.
 */
public class BeneficiaryConstraintValidator implements BeneficiaryConsistenceValidator {
    @Override
    public void initialize(BeneficiaryConsistance constraintAnnotation) {

    }

    @Override
    public boolean isValid(BeneficiaryInfo value, ConstraintValidatorContext context) {
        String bankCode = value.getBankData().getBankCode();
        Iban iban = Iban.valueOf(value.getIban());
        return iban.getBankCode().equals(bankCode);
    }
}
