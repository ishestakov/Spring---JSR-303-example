package com.test.validation.context;

import com.test.validation.constraints.validators.*;
import com.test.validation.constraints.validators.impl.*;
import com.test.validation.service.AccountService;
import com.test.validation.service.PaymentService;
import com.test.validation.service.impl.OddAccountServiceImpl;
import com.test.validation.service.impl.PaymentServiceImpl;
import com.test.validation.spring.ContextConstraintValidatorFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import javax.validation.ConstraintValidatorFactory;
import javax.validation.ValidatorFactory;

/**
 * Created by illia on 3/2/14.
 */
@Configuration
public class AppContext {

    @Bean
    public PaymentService paymentService() {
        return new PaymentServiceImpl();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(AutowireCapableBeanFactory beanFactory) {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidatorFactory(validatorFactory(beanFactory));
        return postProcessor;
    }

    @Bean
    public ValidatorFactory validatorFactory(AutowireCapableBeanFactory beanFactory) {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setConstraintValidatorFactory(constraintValidatorFactory(beanFactory));
        return factoryBean;
    }

    @Bean()
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public SwiftValidator swiftValidator() {
        return new SwiftConstraintValidator();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public CurrencyValidator currencyValidator () {
        return new CurrencyConstraintValidator();
    }

    @Bean
    public ConstraintValidatorFactory constraintValidatorFactory(AutowireCapableBeanFactory beanFactory) {
        return new ContextConstraintValidatorFactory(beanFactory);
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public BeneficiaryConsistenceValidator beneficiaryConsistenceValidator() {
        return new BeneficiaryConstraintValidator();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public IbanValidator ibanValidator() {
        return new IbanConstraintValidator();
    }

    @Bean
    public AccountService accountService() {
        return new OddAccountServiceImpl();
    }

    @Bean
    public AccountValidator accountValidator() {
        return new AcountConstraintValidator();
    }
}
