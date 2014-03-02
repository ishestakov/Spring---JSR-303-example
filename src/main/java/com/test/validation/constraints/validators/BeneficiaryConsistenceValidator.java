package com.test.validation.constraints.validators;

import com.test.validation.constraints.BeneficiaryConsistance;
import com.test.validation.domain.BeneficiaryInfo;

import javax.validation.ConstraintValidator;

/**
 * Created by illia on 3/3/14.
 */
public interface BeneficiaryConsistenceValidator extends ConstraintValidator<BeneficiaryConsistance, BeneficiaryInfo> {
}
