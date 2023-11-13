package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String stringConexao = "jdbc:mysql://localhost:3306?VerifyServerCertificate=false&useSSL=true";
        String usuario = "devkevin";
        String senha   = "Teste123@!";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(stringConexao,usuario,senha);
            conexao.close();
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        System.out.println("Deu boa");

    }
}