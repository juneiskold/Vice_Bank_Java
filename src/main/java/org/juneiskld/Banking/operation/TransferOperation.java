package org.juneiskld.Banking.operation;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.account.Transaction;

public class TransferOperation {

    public static boolean execute(Account sender, Account recipient, double amount) {

        if (WithdrawOperation.execute(sender, amount)) {
            DepositOperation.execute(recipient, amount);
            sender.addTransaction(new Transaction("Transfer to " + recipient.getAccountNumber(), -amount));
            return true;

        }
        return false;
    }
}
