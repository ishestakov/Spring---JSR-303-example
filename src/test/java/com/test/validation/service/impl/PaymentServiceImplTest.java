package com.test.validation.service.impl;

import com.test.validation.context.AppContext;
import com.test.validation.domain.*;
import com.test.validation.service.PaymentService;
import junit.framework.Assert;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by illia on 3/2/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContext.class)
public class PaymentServiceImplTest {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PaymentService service;

    @Test (expected = ConstraintViolationException.class)
    public void testCreate() throws Exception {
        service.create(null);
    }

    @Test
    public void testCreate_incorrectData() throws Exception {
        PaymentData paymentData = new PaymentData();
        paymentData.setPaymentCurrency(Currency.RUR);
        paymentData.setAmount(new BigDecimal(0));
        paymentData.setValueDate(new Date());
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setId(1L);
        Account account = new Account();
        account.setAccountNumber("222221");
        account.setCurrency(Currency.UAH);
        clientInfo.setAccount(account);

        paymentData.setClientInfo(clientInfo);
        BeneficiaryInfo benInfo = new BeneficiaryInfo();
        benInfo.setFullName("John Doe");
        benInfo.setIban("CH5108781000012312300");
        BankData bankData = new BankData();
        bankData.setBankCode("123456");
        bankData.setName("Test bank");
        bankData.setSwift("SWQBCHZZXX");
        benInfo.setBankData(bankData);
        paymentData.setBeneficiaryInfo(benInfo);

        try {
            service.create(paymentData);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation violation : e.getConstraintViolations()) {
                logger.warn(violation.getPropertyPath() + " " + violation.getMessage());
            }
        }
    }

    @Test
    public void testCreate_correctData() throws Exception {
        PaymentData paymentData = new PaymentData();
        paymentData.setPaymentCurrency(Currency.CHF);
        paymentData.setAmount(new BigDecimal(0));
        paymentData.setValueDate(DateTime.now().plusWeeks(1).toDate());
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setId(1L);
        Account account = new Account();
        account.setAccountNumber("222222");
        account.setCurrency(Currency.UAH);
        clientInfo.setAccount(account);

        paymentData.setClientInfo(clientInfo);
        BeneficiaryInfo benInfo = new BeneficiaryInfo();
        benInfo.setFullName("John Doe");
        benInfo.setIban("CH5108781000012312300");
        BankData bankData = new BankData();
        bankData.setBankCode("08781");
        bankData.setName("Test bank");
        bankData.setSwift("SWQBCHZZXXX");
        benInfo.setBankData(bankData);
        paymentData.setBeneficiaryInfo(benInfo);

        try {
            service.create(paymentData);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation violation : e.getConstraintViolations()) {
                logger.warn(violation.getPropertyPath() + " " + violation.getMessage());
            }
            Assert.fail();
        }
    }

}
