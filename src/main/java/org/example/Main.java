package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:55432/ventas", "gerente", "123");

            // Realiza una consulta
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM proveedor");

            // Itera sobre los resultados
            while (resultSet.next()) {
                System.out.println(resultSet.getString("proveedor"));
            }

            // Cierra la conexión
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}