package org.juneiskld.Banking.account;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Transaction {

    private LocalDateTime timestamp;

    private String description;

    private BigDecimal amount;
    private Currency currency;

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
