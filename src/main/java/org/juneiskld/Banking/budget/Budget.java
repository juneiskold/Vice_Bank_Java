package org.juneiskld.Banking.budget;

import java.util.HashMap;
import java.util.Map;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Budget {

    public static final Logger logger = Logger.getLogger(Budget.class.getName());

    private BigDecimal income;

    private final Map<String, BigDecimal> expenses;

    public Budget(BigDecimal income) {
        this.income = Optional.ofNullable(income).orElse(BigDecimal.ZERO);
        this.expenses = new HashMap<>();
    }

    public void setIncome(BigDecimal income) {
        this.income = Optional.ofNullable(income).filter(i -> i.signum() >= 0)
                .orElseThrow(() -> new IllegalArgumentException("Income must be non-negative"));
        logger.log(Level.INFO, "Income set to {0}", this.income);
    }

    public void addExpense(String category, BigDecimal amount) {
        if (Objects.nonNull(amount) && amount.signum() >0) {
            expenses.merge(category, amount, BigDecimal::add);
            logger.log(Level.INFO, "Added expense amount for category {1}", new Object[]{amount, category});

        } else {
            logger.log(Level.WARNING, "Invalid expense amount for category {0}: {1}", new Object[]{category, amount});
        }
    }

    public BigDecimal getRemainingBudget() {

        BigDecimal totalExpenses = expenses.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return income.subtract(totalExpenses);
    }

    public void displayBudget() {

        logger.log(Level.INFO, "Displaying budget summary");
        System.out.printf("Income: R%.2f%\n", income);

        System.out.println("Expenses:");
        expenses.forEach((category, amount) -> System.out.printf("  %s: R%.2f%\n", category, amount));
        System.out.printf("Remaining: R%.2f\n", getRemainingBudget());
    }
}
