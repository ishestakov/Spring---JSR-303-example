package com.test.validation.domain;

import com.test.validation.constraints.ValidCurrency;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by illia on 3/2/14.
 */
public class PaymentData {
    @NotNull
    @Max(value = 999999999)
    @Min(value = 0)
    BigDecimal amount;

    @NotNull
    @ValidCurrency(excludeCurrencies = {Currency.RUR})
    Currency paymentCurrency;

    @Valid
    ClientInfo clientInfo;

    @Valid
    BeneficiaryInfo beneficiaryInfo;

    @Future
    Date valueDate;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public BeneficiaryInfo getBeneficiaryInfo() {
        return beneficiaryInfo;
    }

    public void setBeneficiaryInfo(BeneficiaryInfo beneficiaryInfo) {
        this.beneficiaryInfo = beneficiaryInfo;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public Currency getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(Currency paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }
}
