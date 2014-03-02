package com.test.validation.service;

import com.test.validation.domain.PaymentData;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by illia on 3/2/14.
 */
@Validated
public interface PaymentService {
    public void create(@NotNull @Valid PaymentData paymentData);
}
