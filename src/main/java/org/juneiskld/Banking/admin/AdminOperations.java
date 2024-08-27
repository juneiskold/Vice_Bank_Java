package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.bank.Bank;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminOperations {

    private static final Logger logger = Logger.getLogger(AdminOperations.class.getName());

    public static void performAdminOperations(Scanner scanner, Bank bank) {
        try {
            if (!authenticateAdmin(scanner)) {
                logger.warning("Admin authentication failed. Exiting operations.");
                return;
            }

            boolean keepRunning = true;
            while (keepRunning) {
                displayMenu();

                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            ViewAccountsOperation.execute(bank);
                            break;

                        case 2:
                            DeleteAccountOperation.execute(scanner, bank);
                            break;

                        case 0:
                            System.out.println("Returning to main menu...");
                            keepRunning = false;
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (NumberFormatException ex) {
                    logger.warning("Invalid input. Please enter a number.");

                } catch (Exception e) {
                    logger.log(Level.SEVERE, "An unexpected error occurred.", e);
                }
            }
        } finally {
            logger.info("Admin operations completed.");
        }
    }

    private static boolean authenticateAdmin(Scanner scanner) {
        String password;
        boolean authenticated = false;

        while (!authenticated) {
            System.out.print("Enter admin password: ");
            password = scanner.nextLine();

            if (AdminAuth.authenticate(password)) {
                authenticated = true;
                System.out.println("Authentication successful. Welcome admin!");

            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        }
        return authenticated;
    }

    private static void displayMenu() {
        System.out.println("\nAdmin operations:");
        System.out.println("1. View all Account Numbers");
        System.out.println("2. Delete Account");
        System.out.println("0. Back to Main Menu");

        System.out.println("Choose an option: ");
    }
}
