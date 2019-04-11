package com.snilssave.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.snilssave.OracleConnection.OracleConnection.getOracleConnection;

public class SnilsSaveDB {

    public SnilsSaveDB() {
    }

    public void snilsInsert(String s) throws SQLException {

        String selectTableSQL = s;
        Statement statement = null;

            Connection connection= getOracleConnection();
            statement = connection.createStatement();
            // get data from DB
            statement.executeQuery(selectTableSQL);
    }
}
