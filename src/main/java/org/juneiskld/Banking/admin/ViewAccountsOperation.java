package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.bank.Bank;

import java.util.List;

public class ViewAccountsOperation {

    public static void execute(Bank bank) {

        List<String> accountNumbers = bank.getAllAccountNumbers();
        System.out.println("All Account Numbers:");

        for (String accountNumber : accountNumbers) {
            System.out.println(accountNumber);
        }
    }
}
