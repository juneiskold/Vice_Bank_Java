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
}