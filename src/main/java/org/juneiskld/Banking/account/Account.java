package org.juneiskld.Banking.account;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private String ownerName;

    private double balance;

    private List<Transaction> transactions;

    public Account(String accountNumber, String ownerName, double initialBalance) {
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
        return new ArrayList<>(transactions);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
