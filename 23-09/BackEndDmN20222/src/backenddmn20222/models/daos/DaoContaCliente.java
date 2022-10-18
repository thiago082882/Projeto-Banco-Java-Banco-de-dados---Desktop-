/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.ContaCliente;
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
public class DaoContaCliente {
     private final Connection c;
    
    public DaoContaCliente() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }


    public ContaCliente excluir(ContaCliente concliEnt) throws SQLException{
        String sql = "delete from contas_clientes WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,concliEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return concliEnt;
    }
    
    public ContaCliente buscar(ContaCliente concliEnt) throws SQLException{
        String sql = "select * from contas_clientes WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,concliEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
           ContaCliente concliSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                concliSaida = new ContaCliente(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return concliSaida;
   }

    public ContaCliente inserir(ContaCliente concliEnt) throws SQLException{
        String sql = "insert into contas_clientes " + " (idConta, idCliente)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, concliEnt.getIdConta());
        stmt.setInt(2, concliEnt.getIdCliente());
        

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            concliEnt.setId(id);
        }
        stmt.close();
        return concliEnt;
    }

    public ContaCliente alterar(ContaCliente concliEnt) throws SQLException{
        String sql = "UPDATE contas_clientes SET idCliente = ?, idConta = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
       
        stmt.setInt(1,concliEnt.getIdCliente());
         stmt.setInt(2,concliEnt.getIdConta());
        stmt.setInt(3,concliEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return concliEnt;
    }

   public List<ContaCliente> listar(ContaCliente concliEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<ContaCliente> conclis = new ArrayList<>();
        
        String sql = "select * from contas_clientes where id like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + concliEnt.getId()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
           ContaCliente concli = new ContaCliente(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3));
            // adiciona o usu à lista de usus
            conclis.add(concli);
        }
        
        rs.close();
        stmt.close();
        return conclis;
   
   }

}
