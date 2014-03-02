package com.test.validation.constraints.validators.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.test.validation.constraints.ValidSwift;
import com.test.validation.constraints.validators.SwiftValidator;

import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;

/**
 * Created by illia on 3/2/14.
 */
public class SwiftConstraintValidator implements SwiftValidator {

    private static final List<String> allowedSwifts = ImmutableList.<String>builder()
            .add("SWQBCHZZXXX")
            .add("VABAUAUKXXX")
            .add("DEUTDEFFXXX")
            .build();

    private ValidSwift constraint;

    @Override
    public void initialize(ValidSwift constraintAnnotation) {
        constraint = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return allowedSwifts.contains(value);
    }
}
