package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.bank.Bank;
import org.juneiskld.Banking.account.Account;


import java.util.Scanner;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAccountOperation {

    private static final Logger logger = LoggerFactory.getLogger(DeleteAccountOperation.class);

    public  static void execute(Scanner scanner, Bank bank) {

        System.out.print("Enter account number to delete: ");
        String accountNumber = scanner.nextLine();

        if (accountNumber.isEmpty()) {
            System.out.println("Account number cannot be empty.");
            return;
        }

        try {
            Account account = bank.getAccount(accountNumber); // this code could be refactored to getAccountByNumber

            if (account == null) {
                boolean deletionSuccessful = bank.deleteAccount(accountNumber);

                if (deletionSuccessful) {
                    logger.info("Account {} successfully deleted. Owner: {}, Balance before deletion: {}",
                            accountNumber, account.getOwnerName(), account.getBalance());

                    System.out.println("Account " + accountNumber + " has been deleted.");

                    // optionally show the remaining accounts
                    List<Account> remainingAccounts = bank.getAllAccountNumbers();
                    System.out.println("Remaining accounts: " + remainingAccounts.size());

                } else {
                    logger.warn("Failed to delete account {}. Deletion attempt failed.", accountNumber);
                    System.out.println("Deletion failed due to an unexpected issue.");
                }

            } else {
                logger.warn("Failed to delete account {}. Account not found.", accountNumber);
                System.out.println("Account not found. Deletion failed");
            }
        } catch (Exception e) {
            logger.error("Error deleting account {}: {}", accountNumber, e.getMessage());
            System.out.println("An error occurred while trying to delete account. Please try again. If the issue persists, contact support.");
        }
    }
}
