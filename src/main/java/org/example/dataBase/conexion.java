package org.example.dataBase;
import java.sql.*;

public class conexion {
    private static conexion instance;

    private Connection connection;

    private conexion() throws Exception {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:55432/ventas", "gerente", "123");
    }

    public static conexion getInstance() throws Exception {
        if (instance == null) {
            instance = new conexion();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void openConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:55432/ventas", "gerente", "123");
        }
    }

    public void closeConnection() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws Exception {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
}