package org.juneiskld.Banking.account;

import java.time.LocalDateTime;

public class Transaction {

    private LocalDateTime timestamp;

    private String description;

    private double amount;

    public Transaction(String description, double amount) {

        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s: %s - R%.2f", timestamp, description, amount);
    }
}
