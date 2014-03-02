package com.test.validation.domain;

import com.test.validation.constraints.ValidCurrency;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by illia on 3/2/14.
 */
public class Account {
    @NotNull
    @Size(min = 6, max = 6)
    private String accountNumber;
    @NotNull
    @ValidCurrency(excludeCurrencies = Currency.RUR)
    private Currency currency;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
