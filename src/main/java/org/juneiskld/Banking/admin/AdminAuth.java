package org.juneiskld.Banking.admin;

import org.mindrot.jbcrypt.BCrypt;

public class AdminAuth {

    private static final String STORED_HASHED_PASSWORD = getHashedAdminPassword();

    public static boolean authenticate(String password) {
        return BCrypt.checkpw(password, STORED_HASHED_PASSWORD);
    }



}
