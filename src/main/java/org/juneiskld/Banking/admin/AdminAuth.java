package org.juneiskld.Banking.admin;

public class AdminAuth {

    private String username;
    private String password;

    public AdminAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}