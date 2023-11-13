package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdatePessoas {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Deseja procurar qual nome? ");
        String pesquisa = entrada.nextLine();

        Connection conexao = Connections.getConexao();
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, "%" + pesquisa + "%");
        ResultSet resultado = statement.executeQuery();


        List<Pessoa> pessoas = new ArrayList<>();

        while(resultado.next()){
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo,nome));
        }

        for(Pessoa p: pessoas){
            System.out.println(p.getCodigo() + " ==> " + p.getNome());
        }

        statement.close();

        System.out.println("Digite o ID de quem deseja alterar o nome: ");
        int id = entrada.nextInt();

        System.out.println("Para qual nome deseja alterar?");
        String novoNome = entrada.next();

        sql = "UPDATE pessoas SET nome = ? where codigo = ?";

        statement = conexao.prepareStatement(sql);
        statement.setString(1, novoNome);
        statement.setInt(2, id);
        statement.execute();

        statement.close();
        entrada.close();
    }
}
