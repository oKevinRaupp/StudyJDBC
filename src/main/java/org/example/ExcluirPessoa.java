package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o codigo para deletar.");
        int codigo = entrada.nextInt();

        Connection conexao = Connections.getConexao();
        String sql = "DELETE FROM pessoas WHERE codigo = ?";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1,codigo);

        if(statement.executeUpdate() > 0){
            System.out.println("Registro deletado com sucesso!");
        } else {
            System.out.println("Não foi realizada nenhuma operação.");
        }

        conexao.close();
        entrada.close();
    }
}
