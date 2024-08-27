package org.juneiskld.Banking.admin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class AdminAuth {

    private static final String HASHED_ADMIN_PASSWORD = "$2a$12$ZzKvTqyRtQxwWpBnFgYkYeOoJrGmLXhPbVlMqUuqzHcSfDlqzIiE";

    public static boolean authenticate(String password) throws NoSuchAlgorithmException {
        return ADMIN_PASSWORD.equals(password);
    }
}
