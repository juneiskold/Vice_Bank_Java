package org.juneiskld.Banking.operation;

import org.juneiskld.Banking.account.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

public class BalanceOperation {

    private static final Logger logger = LoggerFactory.getLogger(BalanceOperation.class);

    public static CompletableFuture<BigDecimal> execute(Account account) {

        if (account == null) {
            logger.error("Attempted to balance for null account");
            return CompletableFuture.failedFuture(new NullPointerException("Account is null"));
        }

        return CompletableFuture.supplyAsync(() ->  {
            BigDecimal balance = account.getBalance();
            logger.info("Balance for account {}: {}", account.getAccountNumber(), balance);
            return balance;

        }).exceptionally(ex -> {
            logger.error("Error retrieving balance for account {}: {}", account.getAccountNumber(), ex.getMessage());
            throw new RuntimeException("Failed to retrieve balance", ex);
        });
    }

}
