package org.juneiskld.Banking.operation;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.account.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

public class TransferOperation {

    private static final Logger logger = LoggerFactory.getLogger(TransferOperation.class)

    public static CompletableFuture<Boolean> execute(Account sender, Account recipient, BigDecimal amount) {

        if (sender == null || recipient == null) {
            logger.error("Attempted to transfer with null account");
            return CompletableFuture.failedFuture(new NullPointerException("One or both accounts are null"));
        }

        if (amount == null || amount.signum() <= 0) {
            logger.warn("Invalid transfer amount: {}", amount);
            return CompletableFuture.completedFuture(false);
        }

        synchronized (sender) {
            synchronized (recipient) {

                // ensure sender has sufficient funds
                if (sender.getBalance().compareTo(amount) < 0) {
                    logger.warn("Insufficient funds for transfer. Sender balance: {}", sender.getBalance());
                    return CompletableFuture.completedFuture(false);
                }

            } // perform withdrawal from sender
            sender.setBalance(sender.getBalance().subtract(amount));
            Transaction senderTransaction  = new Transaction("Transfer to " + recipient.getAccountNumber(), amount.negate(), sender.getCurrency());
            sender.addTransaction(senderTransaction);

            // perform deposit to recipient
            recipient.setBalance(recipient.getBalance().add(amount));
            Transaction recipientTransaction = new Transaction("Received from " + sender.getAccountNumber(), amount, recipient.getCurrency());
            recipient.addTransaction(recipientTransaction);

            logger.info("Successful transfer of {} from {} to {}. New balances: Sender ={}, Recipient={}",
                    amount, sender.getAccountNumber(), recipient.getAccountNumber(),
                    sender.getBalance(), recipient.getBalance());

            return CompletableFuture.completedFuture(true);
        }
    }
}
