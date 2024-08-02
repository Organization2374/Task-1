package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:postgresql://localhost:5432/users";
    private static final String USER = "postgres";
    private static final String PASSWORD = "P@ssw0rd";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
