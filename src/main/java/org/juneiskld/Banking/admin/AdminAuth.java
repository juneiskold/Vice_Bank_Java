package org.juneiskld.Banking.admin;

public class AdminAuth {

    private static final String ADMIN_PASSWORD = "admin123";

    public static boolean authenticate(String password) {
        return ADMIN_PASSWORD.equals(password);
    }
}
