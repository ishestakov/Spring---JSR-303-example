package com.test.validation.domain;

import com.test.validation.constraints.ValidAccount;

/**
 * Created by illia on 3/2/14.
 */
public class ClientInfo {
    private Long id;
    @ValidAccount
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
