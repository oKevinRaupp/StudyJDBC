package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        String nome = entrada.next();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)";

        Connection conexao = Connections.getConexao();
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1,nome);
        statement.execute();

        System.out.println("Deu boa! ");
        entrada.close();
    }
}
