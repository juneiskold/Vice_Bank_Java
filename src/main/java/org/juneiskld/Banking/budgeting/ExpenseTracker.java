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


}
