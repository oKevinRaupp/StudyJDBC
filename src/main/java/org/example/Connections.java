package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    public static Connection getConexao(){
        try{
            String stringConexao = "jdbc:mysql://localhost:3306?VerifyServerCertificate=false&useSSL=true";
            String usuario = "devkevin";
            String senha   = "Teste123@!";
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(stringConexao,usuario,senha);
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}
