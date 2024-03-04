package com.codegym.case_mess.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONN_URL = "jdbc:mysql://localhost:3306/cass_mess";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "01666553995";

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver for jdbc connection!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not find database!");
            e.printStackTrace();
        }
        return null;
    }
}
