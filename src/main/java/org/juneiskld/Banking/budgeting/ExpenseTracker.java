package org.juneiskld.Banking.budgeting;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {

    private  List<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String category, double amount) {
        expenses.add(new Expense(category, amount));
    }

    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double getCategoryExpenses(String category) {
        return expenses.stream()
                .filter(e -> e.getCategory().equals(category))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    private static class Expense {

        private String category;
        private double amount;

        public Expense(String category, double amount) {
            this.category = category;
            this.amount = amount;
        }

        public String getCategory() {
            return category;
        }

        public double getAmount() {
            return amount;
        }
    }
}
