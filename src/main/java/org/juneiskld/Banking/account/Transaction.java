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

    public Transaction(String description, BigDecimal amount, Currency currency) {

        if  (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }

        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("%s: %s - R%.2f", timestamp, description, amount);
    }
}
