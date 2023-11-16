package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirCurso {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Connections.getConexao();

        String sql = """
                INSERT INTO curso (curso) VALUES('SQL'),('Programacao'),
                ('JAVA');""";

        Statement statement = conexao.createStatement();
        statement.execute(sql);

        System.out.println("Deu boa");
        conexao.close();
    }
}
