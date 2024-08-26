package org.juneiskld.Banking.bank;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.operation.BalanceOperation;
import org.juneiskld.Banking.operation.DepositOperation;
import org.juneiskld.Banking.operation.TransferOperation;
import org.juneiskld.Banking.operation.WithdrawOperation;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
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
}
