package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.bank.Bank;
import org.juneiskld.Banking.utils.PaginationHelper;

import java.util.List;
import java.util.Scanner;

public class ViewAccountsOperation {

    public static void execute(Bank bank) {
        List<String> accountNumbers = bank.getAllAccountNumbers();

        if (accountNumbers == null || accountNumbers.isEmpty()) {
            System.out.println("No accounts found in the bank.");
            return;
        }
        System.out.println("All Account Numbers:");

        for (String accountNumber : accountNumbers) {
            System.out.println(accountNumber);
        }
    }
}
