package org.juneiskld.Banking.account;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Collections;

public class Account {

    private final String accountNumber;
    private final String ownerName;

    private BigDecimal balance;

    private final List<Transaction> transactions;

    public Account(String accountNumber, String ownerName, BigDecimal initialBalance) {

        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }

        if (ownerName == null || ownerName.isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be null or empty");
        }

        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Initial balance must be a positive");
        }

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
//        return new ArrayList<>(transactions);
        return Collections.unmodifiableList(transactions);
    }

    public void addTransaction(Transaction transaction) {

        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        transactions.add(transaction);
    }
}
