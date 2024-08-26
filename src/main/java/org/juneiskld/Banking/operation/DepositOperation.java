package org.juneiskld.Banking.operation;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.account.Transaction;

public class DepositOperation {

    public static void execute(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        account.addTransaction(new Transaction("Deposit", amount));
    }
}
