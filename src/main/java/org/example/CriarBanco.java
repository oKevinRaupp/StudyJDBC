package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) {
        final String stringConexao = "jdbc:mysql://localhost:3306?VerifyServerCertificate=false&useSSL=true";
        final String usuario = "devkevin";
        final String senha   = "Teste123@!";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(stringConexao,usuario,senha);

            Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE curso_java");
            System.out.println("Banco criado com sucesso!");
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();

        }
    }
}
