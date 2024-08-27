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

    private String generateAccountNumber(long accountID) {
        return String.format("%010d", accountID);
    }

    public Account createAccount(String ownerName, double initialBalance) {
        lock.writeLock().lock();
        try {
            long accountID  = generateNextAccountID();
            String accountNumber = generateAccountNumber(accountID);
            Account newAccount = new Account(accountNumber, ownerName, initialBalance);
            accounts.put(accountID, newAccount);
            logger.info("Created new account {}", accountNumber);
            return newAccount;

        } finally {
            lock.writeLock().unlock();
        }
    }

    public Account getAccount(Long accountNumber) {

        // no need for separate locking here if already handled in calling method
        return accounts.get(accountNumber);
    }

    public void deposit(Long accountNumber, double amount) {
        lock.writeLock().lock(); // upgrade to write lock as balance is being modified

        try {
            Account account = getAccount(accountNumber);

            if (account != null) {
                DepositOperation.execute(account, amount);
                logger.info("Deposited {} into account {}", amount, account.getAccountNumber());

            } else {
                logger.warn("Attempted deposit into non-existent account: {}", accountNumber);

            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean withdraw(Long accountNumber, double amount) {
        lock.writeLock().lock(); // upgrade to write lock for modifying balance

        try {
            Account account = accounts.get(accountNumber);

            if (account != null) {
                return WithdrawOperation.execute(account, amount);
            }
            logger.warn("Attempted withdrawal into non-existent account: {}", accountNumber);
            return false;

        } finally {
            lock.writeLock().unlock();
        }

    }

    public boolean transfer(Long senderAccountNumber, Long recipientAccountNumber, double amount) {
        lock.writeLock().lock(); // upgrade to writ lock for modifying balances

        try {
            Account sender = accounts.get(senderAccountNumber);
            Account recipient = accounts.get(recipientAccountNumber);

            if (sender != null && recipient != null) {
                return TransferOperation.execute(sender, recipient, amount);
            }
            logger.warn("One or both accounts do not exist for transfer: {}, {}", senderAccountNumber, recipientAccountNumber);
            return false;

        } finally {
            lock.writeLock().unlock();
        }
    }

    public double getBalance(Long accountNumber) {
        lock.readLock().lock();

        try {
            Account account = accounts.get(accountNumber);

            if (account != null) {
                return BalanceOperation.execute(account);
            }
            logger.warn("Attempted balance inquiry for non-existent account: {}", accountNumber);
            return -1;

        } finally {
            lock.readLock().unlock();
        }

    }

    public List<Long> getAllAccountNumbers() {
        lock.readLock().lock();

        try {
            return new ArrayList<>(accounts.keySet());
        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean deleteAccount(Long accountNumber) {
        lock.writeLock().lock();

        try {
            if (accounts.containsKey(accountNumber)) {
                accounts.remove(accountNumber);
                logger.info("Deleted account {}", accountNumber);
                return true;

            }
            logger.warn("Attempted deletion of non-existent account: {}", accountNumber);
            return false;

        } finally {
            lock.writeLock().unlock();
        }
    }
}
