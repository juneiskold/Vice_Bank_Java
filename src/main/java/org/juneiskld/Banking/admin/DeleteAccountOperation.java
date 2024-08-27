package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.bank.Bank;
import org.juneiskld.Banking.account.Account;


import java.util.Scanner;
import org.slf4j.Logger;

public class DeleteAccountOperation {

    public  static void execute(Scanner scanner, Bank bank) {

        System.out.print("Enter account number to delete: ");
        String accountNumber = scanner.nextLine();

        if (bank.deleteAccount(accountNumber)) {

            System.out.println("Account " + accountNumber + " has been deleted.");

        } else {
            System.out.println("Account not found. Deletion failed.");
        }
    }
}
