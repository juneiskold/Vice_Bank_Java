package org.juneiskld.Banking;

import org.juneiskld.Banking.admin.AdminAuth;
import org.juneiskld.Banking.banking.bank.Bank;
import org.juneiskld.Banking.banking.accounts.Account;
import org.juneiskld.Banking.budgeting.Budget;
import org.juneiskld.Banking.grocery.GroceryList;
import org.juneiskld.Banking.persistence.Database;
import org.juneiskld.Banking.ui.UserInterface;

public class Main {
    private static AdminAuth adminAuth;
    private static Bank bank;
    private static Budget budget;
    private static GroceryList groceryList;
    private static Database database;
    private static UserInterface ui;

    public static void main(String[] args) {
        initializeComponents();
        startApplication();
    }

    private static void initializeComponents() {
        // Initialize admin authentication
        adminAuth = new AdminAuth("admin", "password"); // In a real application, use secure password handling

        // Initialize bank
        bank = new Bank(/* parameters */);

        // Initialize budget
        budget = new Budget(5000.0); // Example total budget

        // Initialize grocery list
        groceryList = new GroceryList();

        // Initialize database
        database = new Database();

        // Initialize user interface
        ui = new UserInterface();
    }

    private static void startApplication() {
        // Here you would typically:
        // 1. Load any necessary data from the database
        // 2. Set up any background tasks or services
        // 3. Display the user interface

        // For this example, we'll just display the UI
        ui.display();

        // You might also want to add a shutdown hook to save data when the application closes
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Save any unsaved data to the database
            System.out.println("Saving data and shutting down...");
        }));
    }

    // You might want to add getter methods for the components if they need to be accessed from other parts of the application
    public static AdminAuth getAdminAuth() {
        return adminAuth;
    }

    public static Bank getBank() {
        return bank;
    }

    public static Budget getBudget() {
        return budget;
    }

    public static GroceryList getGroceryList() {
        return groceryList;
    }

    public static Database getDatabase() {
        return database;
    }
}