package org.juneiskld.Banking.budget;

import java.util.HashMap;
import java.util.Map;

public class Budget {

    private double income;

    private Map<String, Double> expenses;

    public Budget() {

        this.income = 0.00;
        this.expenses = new HashMap<>();
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void addExpense(String category, double amount) {

        expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
    }

    public double getRemainingBudget() {

        double totalExpenses = expenses.values().stream().mapToDouble(Double::doubleValue).sum();
        return income - totalExpenses;
    }

    public void displayBudget() {

        System.out.println("Budget Summary:");
        System.out.printf("Income: R%.2f\n", income);
        System.out.println("Expenses:");

        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.printf("  %s R%.2f\n", entry.getKey(), entry.getValue());
        }
        System.out.printf("Remaining: R%.2f\n", getRemainingBudget());
    }
}
