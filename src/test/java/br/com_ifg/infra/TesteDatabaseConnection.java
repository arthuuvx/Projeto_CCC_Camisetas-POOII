package br.com_ifg.infra;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteDatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexão bem-sucedida ao banco de dados!");
            } else {
                System.out.println("Falha na conexão ao banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        }
    }
}
