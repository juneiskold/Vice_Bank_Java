package org.juneiskld.Banking.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final DatabaseConnection dbConnection;

    public Database() {
        this.dbConnection = new DatabaseConnection();
    }
}
