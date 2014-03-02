package com.test.validation.spring;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.util.Assert;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

/**
 * Created by illia on 3/2/14.
 */
public class ContextConstraintValidatorFactory implements ConstraintValidatorFactory {
    private final AutowireCapableBeanFactory beanFactory;


    /**
     * Create a new SpringConstraintValidatorFactory for the given BeanFactory.
     * @param beanFactory the target BeanFactory
     */
    public ContextConstraintValidatorFactory(AutowireCapableBeanFactory beanFactory) {
        Assert.notNull(beanFactory, "BeanFactory must not be null");
        this.beanFactory = beanFactory;
    }


    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        boolean hasConstraint = this.beanFactory.containsBean(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, key.getSimpleName()));
        T bean = null;
        if (hasConstraint) {
            bean = this.beanFactory.getBean(key);
        } else {
            bean = this.beanFactory.createBean(key);
        }
        return bean;
    }

    public void releaseInstance(ConstraintValidator<?, ?> instance) {
        this.beanFactory.destroyBean(instance);
    }}
