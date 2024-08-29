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

    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}