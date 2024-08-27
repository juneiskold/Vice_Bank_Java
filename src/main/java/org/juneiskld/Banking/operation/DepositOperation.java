package org.juneiskld.Banking.operation;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.account.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class DepositOperation {

    private static final Logger logger = LoggerFactory.getLogger(DepositOperation.class);

    public static void execute(Account account, BigDecimal amount) {
        if (account == null) {
            logger.error("Attempted deposit for null amount.");
            return;
        }

        if ( account == null || amount.signum() <= 0) {
            logger.warn("Invalid deposit amount: {}", amount);
            return;
        }

        synchronized (acoount) {
            BigDecimal newBalance = account.getBalance().add(amount);

            // create and add the deposit transaction
            Transaction transaction = new Transaction("Deposit", amount, account.getCurrency());
            account.addTransaction(transaction);

            // update the account balance
            account.setBalance(newBalance);

            logger.info("Deposited {} into account {}. New balance: {}", amount, account.getAccountNumber(), newBalance);
        }
    }
}
