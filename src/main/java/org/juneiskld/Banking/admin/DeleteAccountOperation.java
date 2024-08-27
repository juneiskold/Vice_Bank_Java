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

        if
    }
}
