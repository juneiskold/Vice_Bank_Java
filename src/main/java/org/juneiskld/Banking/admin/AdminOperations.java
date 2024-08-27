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
                displayMenu;

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


}
