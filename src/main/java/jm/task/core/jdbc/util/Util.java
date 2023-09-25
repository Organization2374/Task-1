package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String dbDriver = "org.postgresql.Driver";
    private static final String dbURL = "jdbc:postgresql://localhost:5432/local_db";
    private static final String dbUser = "postgres";
    private static final String dbPass = "1234";

    public static Connection openConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL);
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL);
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
