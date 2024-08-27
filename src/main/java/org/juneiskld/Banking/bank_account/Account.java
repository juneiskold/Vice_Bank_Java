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

//    public String getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public AccountHolder getAccountHolder() {
//        return accountHolder;
//    }
//
//    public void setAccountHolder(AccountHolder accountHolder) {
//        this.accountHolder = accountHolder;
//    }
//
//    public Balance getBalance() {
//        return balance;
//    }
//
//    public void setBalance(Balance balance) {
//        this.balance = balance;
//    }
//
//    public AccountType getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(AccountType accountType) {
//        this.accountType = accountType;
//    }
//
//    public InterestRate getInterestRate() {
//        return interestRate;
//    }
//
//    public void setInterestRate(InterestRate interestRate) {
//        this.interestRate = interestRate;
//    }
//
//    public CreationDate getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(CreationDate creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public BranchCode getBranchCode() {
//        return branchCode;
//    }
//
//    public void setBranchCode(BranchCode branchCode) {
//        this.branchCode = branchCode;
//    }
//
//    public Currency getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(Currency currency) {
//        this.currency = currency;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
}