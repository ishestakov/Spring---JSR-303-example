package com.test.validation.service.impl;

import com.test.validation.domain.PaymentData;
import com.test.validation.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * Created by illia on 3/2/14.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Override
    public void create(PaymentData paymentData) {
        LOGGER.info("Creating payment: {}", paymentData);
    }
}
