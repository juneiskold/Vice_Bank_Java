package org.juneiskld.Banking;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.account.Transaction;
import org.juneiskld.Banking.bank.Bank;
import org.juneiskld.Banking.budget.Budget;
import org.juneiskld.Banking.admin.AdminOperations;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        Budget budget = new Budget();

        while (true) {
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

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    Account newAccount = bank.createAccount(ownerName, initialBalance);
                    System.out.println("Account created. Account number: " + newAccount.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccNum = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositAccNum, depositAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccNum = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();

                    if (bank.withdraw(withdrawAccNum, withdrawAmount)) {
                        System.out.println("Withdraw successful.");

                    } else {
                        System.out.println("Withdraw failed. Insufficient funds.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String balanceAccNum = scanner.nextLine();
                    double balance = bank.getBalance(balanceAccNum);

                    if (balance >= 0) {
                        System.out.printf("Balance: R%s\n", formatNumber(balance));

                    } else {
                        System.out.println("Account not found");

                    }
                    break;

                case 5:
                    System.out.print("Enter sender account number: ");
                    String senderAccNum = scanner.nextLine();
                    System.out.print("Enter recipient account number: ");
                    String recipientAccNum = scanner.nextLine();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();

                    if (bank.transfer(senderAccNum, recipientAccNum, transferAmount)) {
                        System.out.println("Transfer successful.");

                    } else {
                        System.out.println("Transfer failed. Check account numbers and balance.");
                    }
                    break;

                case 6:
                    System.out.print("Enter account number: ");
                    String transactionAccNum = scanner.nextLine();
                    Account account = bank.getAccount(transactionAccNum);

                    if (account != null) {
                        for (Transaction t : account.getTransactions()) {
                            System.out.println(t);

                        }

                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 7:
                    System.out.print("Enter income: ");
                    double income = scanner.nextDouble();
                    budget.setIncome(income);
                    System.out.println("Income set successful.");
                    break;

                case 8:
                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    budget.addExpense(category, expenseAmount);
                    System.out.println("Expense added successfully.");
                    break;

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
