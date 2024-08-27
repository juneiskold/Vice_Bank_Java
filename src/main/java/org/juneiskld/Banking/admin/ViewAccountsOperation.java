package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.account.Account;
import org.juneiskld.Banking.bank.Bank;
import org.juneiskld.Banking.utils.PaginationHelper;

import java.util.List;
import java.util.Scanner;

public class ViewAccountsOperation {

    public static void execute(Bank bank) {
        List<String> accountNumbers = bank.getAllAccountNumbers();

        if (accountNumbers == null || accountNumbers.isEmpty()) {
            System.out.println("No accounts found in the bank.");
            return;
        }

        PaginationHelper<String> pagination = new PaginationHelper<>(accountNumbers, 10); // page size set to 10

        int totalPages = pagination.getTotalPages();
        int currentPage = 1;
        Scanner scanner = new Scanner(System.in);

        while (currentPage <= totalPages) {
            pagination.setPage(currentPage);

            System.out.println("\nPage " + currentPage + " of " + totalPages);
            System.out.println("Showing accounts " + (pagination.getPageStart() + 1) + " to " + pagination.getPageEnd());

            List<String> paginatedAccountNumbers = accountNumbers.subList(pagination.getPageStart(), pagination.getPageEnd());

            for (String accountNumber : paginatedAccountNumbers) {
                System.out.printf("%-20s%n", accountNumber);
            }

            System.out.println();

            System.out.print("Enter 'n' for next page, 'p' for previous page, or 'q' to quit: ");
            String input = scanner.nextLine().toLowerCase();

            if ("n".equals(input)) {
                if (currentPage < totalPages) {
                    currentPage++;

                } else {
                    System.out.println("This is the last page.");
                }

            } else if ("p".equals(input)) {
                if (currentPage > totalPages) {
                    currentPage--;

                } else {
                    System.out.println("This is the first page.");
                }
            } else if ("q".equals(input)) {
                break;

            } else {
                System.out.println("Invalid input. Please enter 'n', 'p' or 'q'.");
            }
        }
    }
}
