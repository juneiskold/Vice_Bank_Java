package org.juneiskld.Banking.bank_account;

public class Account {

    private String accountNumber;
    private AccountHolder accountHolder;
    private Balance balance;
    private AccountType accountType;
    private InterestRate interestRate;
    private CreationDate creationDate;
    private BranchCode branchCode;
    private Currency currency;
    private Status status;

    public Account(AccountHolder accountHolder, Balance balance,
                   AccountType accountType, InterestRate interestRate,
                   CreationDate creationDate, BranchCode branchCode,
                   Currency currency, Status status) {

        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.creationDate = creationDate;
        this.branchCode = branchCode;
        this.currency = currency;
        this.status = status;
    }
}