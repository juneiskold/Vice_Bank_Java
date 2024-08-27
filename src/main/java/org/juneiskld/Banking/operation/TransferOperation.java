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

    }
}
