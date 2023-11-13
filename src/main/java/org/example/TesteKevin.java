package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TesteKevin {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        Connection conexao = Connections.getConexao();

        System.out.println("Qual ID deseja alterar?");
        int id = entrada.nextInt();

        System.out.println("Qual o novo nome? ");
        String novoNome = entrada.next();

        String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1,novoNome);
        statement.setInt(2, id);
        statement.execute();

        statement.close();
        entrada.close();

    }
}
