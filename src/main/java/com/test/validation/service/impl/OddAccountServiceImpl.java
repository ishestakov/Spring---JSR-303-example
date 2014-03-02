package com.test.validation.service.impl;

import com.test.validation.service.AccountService;

/**
 * Created by illia on 3/3/14.
 */
public class OddAccountServiceImpl implements AccountService{

    @Override
    public boolean checkIfExist(String accountNumber) {
        return (Integer.parseInt(accountNumber) & 1) == 0;
    }
}
