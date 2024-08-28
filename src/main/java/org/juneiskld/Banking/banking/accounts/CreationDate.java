package org.juneiskld.Banking.banking.accounts;

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
