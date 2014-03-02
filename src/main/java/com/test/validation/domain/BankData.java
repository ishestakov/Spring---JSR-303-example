package com.test.validation.domain;

import com.test.validation.constraints.ValidSwift;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by illia on 3/2/14.
 */
public class BankData {
    @NotNull
    @ValidSwift
    private String swift;
    @Size(min = 2, max = 50)
    private String name;
    @Size(min=3, max=7)
    private String bankCode;

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}
