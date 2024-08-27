package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.bank.Bank;

import java.util.Scanner;
import java.util.List;

public class AdminOperations {

    public static void performAdminOperations(Scanner scanner, Bank bank) {
        boolean authenticated = false;
        String password;

        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (!AdminAuth.authenticate(password)) {
            System.out.println("Incorrect password. Access denied.");
            return;
        }

        while (true) {

            System.out.println("\nAdmin Operations:");
            System.out.println("1. View all Account Numbers");
            System.out.println("2. Delete Account");
            System.out.println("0. Back to Main Menu");
            System.out.print("`Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ViewAccountsOperation.execute(bank);
                    break;

                case 2:
                    DeleteAccountOperation.execute(scanner, bank);
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
