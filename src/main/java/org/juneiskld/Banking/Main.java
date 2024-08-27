package org.juneiskld.Banking;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.account.Transaction;
import org.juneiskld.Banking.bank.Bank;
import org.juneiskld.Banking.budget.Budget;
import org.juneiskld.Banking.admin.AdminOperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;


import java.text.DecimalFormat;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        Budget budget = new Budget(BigDecimal.ZERO);

        Boolean running = true;

        while (running) {
            System.out.println("Welcome to Vice Bank");
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. View Transactions");
            System.out.println("7. Set Income");
            System.out.println("8. Add Expense");
            System.out.println("9. View Budget");
            System.out.println("10. Admin Operations");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = validateNumericInput(scanner);

            switch (choice) {
                case 1:
                    createAccount(scanner, bank);
                    break;
                case 2:
                    deposit(scanner, bank);
                    break;
                case 3:
                    withdraw(scanner, bank);
                    break;
                case 4:
                    checkBalance(scanner, bank);
                    break;
                case 5:
                    transferMoney(scanner, bank);
                    break;
                case 6:
                    viewTransactions(scanner, bank);
                    break;
                case 7:

                case 8:

                case 9:
                    budget.displayBudget();
                    break;

                case 10:
                    AdminOperations.performAdminOperations(scanner, bank);
                    break;

                case 0:
                    System.out.println("Thank you for using Vice Bank");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static String formatNumber(double number) {

        DecimalFormat df = new DecimalFormat("#, ##0.00");
        return df.format(number).replace(",", " ");
    }
}
