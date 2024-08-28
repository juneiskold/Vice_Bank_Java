package org.juneiskld.Banking.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface QueryExecutor<T> {
    T execute(ResultSet rs) throws SQLException;
}