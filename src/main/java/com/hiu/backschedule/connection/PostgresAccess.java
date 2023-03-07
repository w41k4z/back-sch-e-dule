package com.hiu.backschedule.connection;

import java.sql.SQLException;

import orm.database.connection.DatabaseConnection;
import orm.database.connection.PostgresConnection;

public class PostgresAccess extends PostgresConnection {

    // for null connection
    public PostgresAccess() {
    }

    public PostgresAccess(String url, String user, String password) throws SQLException {
        super(url, user, password);
    }

    @Override
    public DatabaseConnection defaultConnection() throws SQLException {
        return new PostgresAccess("jdbc:postgresql://localhost:5432/sch_e_dule", "walker", "w41k4z!");
    }
}
