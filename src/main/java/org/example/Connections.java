package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connections {
    public static Connection getConexao(){
        try{
//            Properties properties = getProperties();
            String stringConexao = "jdbc:mysql://localhost:3306/curso_java?VerifyServerCertificate=false&useSSL=true";
            String usuario = "devkevin";
            String senha   = "Teste123@!";
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(stringConexao,usuario,senha);
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String path = "/conexao.properties";
        properties.load(Connections.class.getResourceAsStream(path));
        return properties;
    }
}
