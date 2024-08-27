package org.juneiskld.Banking.bank;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.operation.BalanceOperation;
import org.juneiskld.Banking.operation.DepositOperation;
import org.juneiskld.Banking.operation.TransferOperation;
import org.juneiskld.Banking.operation.WithdrawOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bank {

    private static final Logger logger = LoggerFactory.getLogger(Bank.class);
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final AtomicLong nextAccounID = new AtomicLong(1);
    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    private long generateNextAccountID() {
        return nextAccounID.incrementAndGet();
    }

    public Account createAccount(String ownerName, double initialBalance) {

        String accountNumber = generateAccountNumber();
        Account newAccount = new Account(accountNumber, ownerName, initialBalance);
        accounts.put(accountNumber, newAccount);
        return newAccount;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    private String generateAccountNumber() {
        return String.format("%010d", accounts.size() + 1);
    }

    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);

        if (account != null) {
            DepositOperation.execute(account, amount);
        }
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);

        if (account != null) {
            return WithdrawOperation.execute(account, amount);
        }
        return false;
    }

    public boolean transfer(String senderAccountNumber, String recipientAccountNumber, double amount) {
        Account sender = getAccount(senderAccountNumber);
        Account recipient = getAccount(recipientAccountNumber);

        if (sender != null && recipient != null) {
            return TransferOperation.execute(sender, recipient, amount);
        }
        return false;
    }

    public double getBalance(String accountNumber) {
        Account account = getAccount(accountNumber);

        if (account != null) {
            return BalanceOperation.execute(account);
        }
        return -1;
    }

    public List<String> getAllAccountNumbers() {

        return new ArrayList<>(accounts.keySet());
    }

    public boolean deleteAccount(String accountNumber) {

        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            return true;

        } return false;
    }
}
