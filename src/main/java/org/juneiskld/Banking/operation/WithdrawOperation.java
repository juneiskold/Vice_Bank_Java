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

    }
}
