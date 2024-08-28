package org.juneiskld.Banking.budgeting;

import java.util.ArrayList;
import java.util.List;

public class IncomeCalculator {

    private List<Income> incomes;

    public IncomeCalculator() {
        this.incomes = new ArrayList<>()
    }

    public void addIncome(String source, double amount) {
        incomes.add(new Income(source, amount));
    }
}
