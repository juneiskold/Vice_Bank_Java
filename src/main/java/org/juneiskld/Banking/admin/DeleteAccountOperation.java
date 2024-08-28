package org.juneiskld.Banking.admin;

public class DeleteAccountOperation implements AdminOperations {

    private String accountNumber;

    public DeleteAccountOperation(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}