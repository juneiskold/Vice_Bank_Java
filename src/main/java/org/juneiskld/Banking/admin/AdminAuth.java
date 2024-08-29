package org.juneiskld.Banking.admin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AdminAuth {

    private String username;
    private String saltedHashedPassword;

    public AdminAuth(String username, String password) throws NoSuchAlgorithmException {

        this.username = username;
        this.saltedHashedPassword = hashPassword(password);
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] bytes = ("salt" + password).getBytes(StandardCharsets.UTF_8);
        byte[] hashBytes = md.digest(bytes);
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public boolean authenticate(String inputUsername, String inputPassword) throws NoSuchAlgorithmException {

        if (!inputUsername.equals(this.username)) {
            return false;
        }

        String inputHashedPassword = hashPassword(inputPassword);
        return inputHashedPassword.equals(this.saltedHashedPassword);
    }
}