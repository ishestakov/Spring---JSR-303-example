package com.test.validation.domain;

import com.test.validation.constraints.BeneficiaryConsistance;
import com.test.validation.constraints.ValidIban;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by illia on 3/2/14.
 */
@BeneficiaryConsistance
public class BeneficiaryInfo {
    @ValidIban
    private String iban;
    @NotNull
    @Size(min = 2, max = 50)
    private String fullName;
    @Valid
    private BankData bankData;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BankData getBankData() {
        return bankData;
    }

    public void setBankData(BankData bankData) {
        this.bankData = bankData;
    }
}
