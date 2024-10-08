package org.juneiskld.Banking.budgeting;

import java.util.HashMap;
import java.util.Map;

public class Budget {

    private double totalBudget;
    private Map<String, Double> categoryBudgets;

    public Budget(double totalBudget) {
        this.totalBudget = totalBudget;
        this.categoryBudgets = new HashMap<>();
    }

    public void setCategoryBudget(String category, double amount) {

        categoryBudgets.put(category, amount);
    }

    public double getCategoryBudget(String category) {
        return categoryBudgets.getOrDefault(category, 0.0);
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

}