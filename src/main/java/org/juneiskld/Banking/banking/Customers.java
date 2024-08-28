package org.juneiskld.Banking.banking;
import java.util.ArrayList;
import java.util.List;

public class Customers {
    private List<Customer> customers;

    public Customers() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
