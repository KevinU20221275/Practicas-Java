package org.montano.java.swing.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJdbc {
    private static String url = "jdbc:mysql://localhost:3306/swing_products";
    private static String user = "kevin";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


}
