package org.juneiskld.Banking.bank_account;

import java.time.LocalDate;

public class CreationDate {

    private LocalDate date;

    public CreationDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
