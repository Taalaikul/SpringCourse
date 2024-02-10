package com.luv2code.aop.demo.dao;

import com.luv2code.aop.demo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
