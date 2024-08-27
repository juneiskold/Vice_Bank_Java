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

        if (initialBalance <= 0) {
            throw new IllegalArgumentException("Initial balance must be positive");
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
//        return new ArrayList<>(transactions);
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
