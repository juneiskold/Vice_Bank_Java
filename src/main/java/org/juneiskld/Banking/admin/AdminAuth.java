package org.juneiskld.Banking.admin;

import org.mindrot.jbcrypt.BCrypt;

public class AdminAuth {

    private static final String STORED_HASHED_PASSWORD = getHashedAdminPassword();

    public static boolean authenticate(String password) {
        return BCrypt.checkpw(password, STORED_HASHED_PASSWORD);
    }

    // simulated method to retrieve the hashed password from a secure storage
    private static String getHashedAdminPassword() {

        // this would normally retrieve the hashed password from a secure storage file like a config file
        return "$2a$12$ZzKvTqyRtQxwWpBnFgYkYeOoJrGmLXhPbVlMqUuqzHcSfDlqzIiE";
    }



}
