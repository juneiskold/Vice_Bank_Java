package org.juneiskld.Banking.bank;

import org.juneiskld.Banking.bank_account.BranchCode;
import org.juneiskld.Banking.bank_account.InterestRate;

public class Bank {

    private BankName bankName;
    private BankCode bankCode;
    private Branches branches;
    private TotalAssets totalAssets;
    private Customers customers;
    private Location location;
    private InterestRates interestRates;
    private ServicesOffered servicesOffered;
    private RegulatoryCompliance regulatoryCompliance;

    public Bank(BankName bankName, BankCode bankCode, Branches branches,
                TotalAssets totalAssets, Customers customers, Location location,
                InterestRates interestRates, ServicesOffered servicesOffered,
                RegulatoryCompliance regulatoryCompliance) {

        this.bankName = bankName;
        this.bankCode = bankCode;
        this.branches = branches;
        this.totalAssets = totalAssets;
        this.customers = customers;
        this.location = location;
        this.interestRates = interestRates;
        this.servicesOffered = servicesOffered;
        this.regulatoryCompliance = regulatoryCompliance;
    }

}
