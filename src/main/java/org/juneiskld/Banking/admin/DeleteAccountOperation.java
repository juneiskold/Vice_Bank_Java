package org.juneiskld.Banking.admin;

public class DeleteAccountOperation implements AdminOperations {

    private String accountNumber;

    public DeleteAccountOperation(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() {
        System.out.println("Deleting account: " + accountNumber);

        // add logic to delete the account from the system
    }
}