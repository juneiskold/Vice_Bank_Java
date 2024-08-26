package org.juneiskld.Banking;

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


}
