package org.juneiskld.Banking.admin;

import java.util.List;

public class ViewAccountsOperation implements AdminOperations{

    @Override
    public void execute() {
        System.out.println("Viewing all accounts:");

        List<String> accounts = getAllAccounts();

        for (String account : accounts) {
            System.out.println(account);
        }
    }

    private List<String> getAllAccounts() {

        // this method should fetch all accounts from the database
        // for now we'll return a dummy list

        return List.of("Account1", "Account2", "Account3");
    }
}