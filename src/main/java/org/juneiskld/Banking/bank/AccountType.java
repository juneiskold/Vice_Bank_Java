package org.juneiskld.Banking.bank;

import java.math.BigDecimal;
import java.util.Currency;

public enum AccountType implements AccountInterestRateCalculator {

    CHECKING(Currency.getInstance("ZAR"), 0.01),
    SAVINGS(Currency.getInstance("ZAR"), 0.02),
    MONEY_MARKET_ACCOUNT(Currency.getInstance("ZAR"), 0.03);

    private final Currency currency;
    private final double interestRate;

    AccountType(Currency currency, double interestRate) {
        this.currency = currency;
        this.interestRate = interestRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    // example implementation of account interest rate calculator method
    @Override
    public BigDecimal calculateInterest(BigDecimal balance) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be null or negative.");
        }
        return balance.multiply(BigDecimal.valueOf(interestRate));
    }
}
