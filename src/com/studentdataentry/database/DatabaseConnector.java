package com.studentdataentry.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnector class handles the creation of a connection to the MySQL database.
 * It uses JDBC to connect to the specified database using the provided credentials.
 */

public class DatabaseConnector {
    // JDBC URL of the MySQL database
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    // Username used to connect to the MySQL database
    private static final String USER = "root";
    // Password used to connect to the MySQL database
    private static final String PASSWORD = "your_password";

    /**
     * Establishes and returns a connection to the database.
     *
     * @return Connection object to interact with the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}