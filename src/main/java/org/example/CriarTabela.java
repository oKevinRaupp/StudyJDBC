package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Connections.getConexao();

        String sql = """
                CREATE TABLE IF NOT EXISTS curso(
                codigo INT AUTO_INCREMENT PRIMARY KEY,
                curso VARCHAR(80) NOT NULL
                )""";

        Statement statement = conexao.createStatement();
        statement.execute(sql);

        System.out.println("Tabela criada com sucesso!");
        conexao.close();
    }
}
