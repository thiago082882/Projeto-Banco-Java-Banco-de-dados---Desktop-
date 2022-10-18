/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.Logradouro;
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
public class DaoLogradouro {

private final Connection c;
    
    public DaoLogradouro() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    
}
    
     public Logradouro excluir(Logradouro logEnt) throws SQLException{
        String sql = "delete from logradouros WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,logEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return logEnt;
    }
      public Logradouro buscar(Logradouro logEnt) throws SQLException{
        String sql = "select * from logradouros WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,logEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Logradouro logSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                logSaida = new Logradouro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
                    
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return logSaida;
   }
      
      public Logradouro inserir(Logradouro logEnt) throws SQLException{
        String sql = "insert into logradouros " + " (endereco, cep, complemento)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,logEnt.getEnd());
        stmt.setString(2,logEnt.getCep());
        stmt.setString(3,logEnt.getComp());


        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            logEnt.setId(id);
        }
        stmt.close();
        return logEnt;
    }

    public Logradouro alterar(Logradouro logEnt) throws SQLException{
        String sql = "UPDATE logradouros SET endereco = ?, cep = ?, complemento = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,logEnt.getEnd());
        stmt.setString(2,logEnt.getCep());
        stmt.setString(3,logEnt.getComp());
        stmt.setInt(5,logEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return logEnt;
    }

   public List<Logradouro> listar(Logradouro logEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Logradouro> listLog = new ArrayList<>();
        
        String sql = "select * from logradouros where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + logEnt.getEnd() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Logradouro log = new Logradouro(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
                
            );
            // adiciona o usu à lista de usus
            listLog.add(log);
        }
        
        rs.close();
        stmt.close();
        return listLog;
   
   }

    
}
