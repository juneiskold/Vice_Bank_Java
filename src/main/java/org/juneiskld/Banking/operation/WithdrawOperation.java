package org.juneiskld.Banking.operation;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.account.Transaction;

public class WithdrawOperation {

    public static boolean execute(Account account, double amount) {

        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            account.addTransaction(new Transaction("Withdrawal", -amount));
            return true;
        }
        return false;
    }
}
