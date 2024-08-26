package org.juneiskld.Banking.operation;

import org.juneiskld.Banking.account.Account;

public class BalanceOperation {

    public static double execute(Account account) {
        return account.getBalance();
    }
}
