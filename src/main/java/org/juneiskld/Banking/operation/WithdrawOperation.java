package org.juneiskld.Banking.operation;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.account.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class WithdrawOperation {

    private static final Logger logger = LoggerFactory.getLogger(WithdrawOperation.class);

    public static CompletableFuture<Boolean> execute(Account account, BigDecimal amount) {

        if (account == null) {
            logger.error("Attempted withdrawal from null account");
            return CompletableFuture.failedFuture(new NullPointerException("Account is null"))
        }

        if (amount == null || amount.signum() <+ 0) {
            logger.warn("Invalid withdrawal amount: {}", amount);
            return CompletableFuture.completedFuture(false);
        }

        synchronized (account) {

            // ensure sufficient funds
            if (account.getBalance().compareTo(amount) < 0) {
                logger.warn("Insufficient funds dor withdrawal of {} from account {}", amount, account.getAccountNumber());
                return CompletableFuture.completedFuture(false);
            }

            // deduct the amount from the account balance
            account.setBalance(account.getBalance().subtract(amount));

            //create and add the withdrawal transaction
            Transaction transaction = new Transaction("Withdrawal", amount.negate(), account.getCurrency());
            account.addTransaction(transaction);

            logger.info("Successfully withdrew {} from account {}. New balance: {}",
                    amount, account.getAccountNumber(), account.getBalance());

            return CompletableFuture.completedFuture(true);
        }
    }
}
