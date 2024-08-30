package org.juneiskld.Banking.admin;

import org.juneiskld.Banking.persistence.Database;

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

        // perform database operation
        deleteAccountFromDatabase();
    }

    private void validateAccount(String accountNumber) {

        // Implement account number validation logic here
        // For example, check if the account number exists in the database
        // If it doesn't exist, log an error and return early
    }

    private void deleteAccountFromDatabase() {
        try (Connection conn = Database.getConnection()) {
            String sql = "DELETE FROM accounts WHERE account_number = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, accountNumber);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected == 0) {
                    logger.log(Level.SEVERE, "No account found with number {0}", accountNumber);
                    System.out.println("No account found with number " + accountNumber);
                    return;
                }

                logger.log(Level.INFO, "Deleted account with number {0}. Rows affected: {1}", new Object[]{accountNumber, rowsAffected});
                System.out.println("Successfully deleted account with number " + accountNumber);
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
                System.err.println("Error deleting account: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
            System.err.println("Error connecting to database: " + ex.getMessage());
        }
    }
}