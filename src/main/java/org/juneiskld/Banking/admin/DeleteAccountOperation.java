package org.juneiskld.Banking.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteAccountOperation implements AdminOperations {

    private String accountNumber;
    private final Logger logger = Logger.getLogger(DeleteAccountOperation.class.getName());

    public DeleteAccountOperation(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() {
        System.out.println("Deleting account: " + accountNumber);

        // add logic to delete the account from the system

        // add validation checks
        validateAccount(accountNumber);
    }
}