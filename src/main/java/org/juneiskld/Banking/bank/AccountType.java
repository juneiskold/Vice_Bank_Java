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
}
