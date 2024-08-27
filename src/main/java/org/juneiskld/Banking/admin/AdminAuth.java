package org.juneiskld.Banking.admin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class AdminAuth {

    private static final String HASHED_ADMIN_PASSWORD = "$2a$12$ZzKvTqyRtQxwWpBnFgYkYeOoJrGmLXhPbVlMqUuqzHcSfDlqzIiE";

    public static boolean authenticate(String password) throws NoSuchAlgorithmException {

        String hashedPassword = hashPassword(password);
        return HASHED_ADMIN_PASSWORD.equals(hashedPassword);
    }

    private static String hashPassword(String password)  throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));

        }
        return sb.toString();
    }
}
