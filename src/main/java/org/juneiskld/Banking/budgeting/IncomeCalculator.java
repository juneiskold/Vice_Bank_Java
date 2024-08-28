package org.juneiskld.Banking.budgeting;

import java.util.ArrayList;
import java.util.List;

public class IncomeCalculator {

    private List<Income> incomes;

    public IncomeCalculator() {
        this.incomes = new ArrayList<>();
    }

    public void addIncome(String source, double amount) {
        incomes.add(new Income(source, amount));
    }

    public double getTotalIncome() {
        return incomes.stream().mapToDouble(Income::getAmount).sum();
    }

    public double getIncomeBySource(String source) {
        return incomes.stream()
                .filter(i -> i.getSource().equals(source))
                .mapToDouble(Income::getAmount)
                .sum();
    }

    private static class Income{

        private String source;
        private double amount;

        public Income(String source, double amount) {
            this.source = source;
            this.amount = amount;
        }

        public String getSource() {
            return source;
        }

        public double getAmount() {
            return amount;
        }
    }
}
