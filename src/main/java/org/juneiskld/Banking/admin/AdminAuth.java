package org.juneiskld.Banking.admin;

import org.mindrot.jbcrypt.BCrypt;

public class AdminAuth {

    private static final String STORED_HASHED_PASSWORD = getHashedAdminPassword();

    public static boolean authenticate(String password) {
        return BCrypt.checkpw(password, STORED_HASHED_PASSWORD);
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

    // method to retrieve the hashed password from a secure storage (config file)
    private static String getHashedAdminPassword() {

        // implement retrieval logic from secure storage
        return HASHED_ADMIN_PASSWORD;
    }

}
