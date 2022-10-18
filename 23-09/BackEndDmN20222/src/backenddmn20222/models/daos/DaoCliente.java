/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.Cliente;
import backenddmn20222.utils.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiag
 */
public class DaoCliente {
    private final Connection c;
    
    public DaoCliente() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    
}
    
     public Cliente excluir(Cliente cliEnt) throws SQLException{
        String sql = "delete from clientes WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,cliEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return cliEnt;
    }
      public Cliente buscar(Cliente cliEnt) throws SQLException{
        String sql = "select * from clientes WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,cliEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Cliente cliSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                cliSaida = new Cliente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                    rs.getString(6));
                    
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return cliSaida;
   }
      
      public Cliente inserir(Cliente cliEnt) throws SQLException{
        String sql = "insert into clientes " + " (nome,cpf,telefone,email,sexo)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,cliEnt.getNome());
        stmt.setString(2,cliEnt.getCpf());
        stmt.setString(3,cliEnt.getTelefone());
        stmt.setString(4,cliEnt.getEmail());
        stmt.setString(5, cliEnt.getSexo());


        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            cliEnt.setId(id);
        }
        stmt.close();
        return cliEnt;
    }

    public Cliente alterar(Cliente cliEnt) throws SQLException{
        String sql = "UPDATE clientes SET nome = ?, cpf = ?, telefone = ?,email = ?,sexo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,cliEnt.getNome());
        stmt.setString(2,cliEnt.getCpf());
        stmt.setString(3,cliEnt.getTelefone());
        stmt.setString(4,cliEnt.getEmail());
        stmt.setString(5,cliEnt.getSexo());
        stmt.setInt(6,cliEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return cliEnt;
    }

   public List<Cliente> listar(Cliente cliEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Cliente> listCli = new ArrayList<>();
        
        String sql = "select * from clientes where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + cliEnt.getNome()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Cliente cli = new Cliente(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6));
            // adiciona o usu à lista de usus
            listCli.add(cli);
        }
        
        rs.close();
        stmt.close();
        return listCli;
   
   }
}
