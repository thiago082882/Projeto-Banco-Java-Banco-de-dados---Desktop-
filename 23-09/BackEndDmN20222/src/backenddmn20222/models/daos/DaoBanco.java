/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.Banco;
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
public class DaoBanco {
        
    private final Connection c;
    
    public DaoBanco() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }


    public Banco excluir(Banco banEnt) throws SQLException{
        String sql = "delete from bancos WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,banEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return banEnt;
    }
    
    public Banco buscar(Banco banEnt) throws SQLException{
        String sql = "select * from bancos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,banEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Banco banSaida = null;
            while (rs.next()) {      
            // criando o objeto Banco
                banSaida = new Banco(
                    rs.getInt(1),
                    rs.getString(2));
                  
                  
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return banSaida;
   }

    public Banco inserir(Banco banEnt) throws SQLException{
        String sql = "insert into bancos " + " (nome_banco)" + " values (?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,banEnt.getNome_banco());
       
       

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            banEnt.setId(id);
        }
        stmt.close();
        return banEnt;
    }

    public Banco alterar(Banco banEnt) throws SQLException{
        String sql = "UPDATE bancos SET nome_banco= ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
       stmt.setString(1,banEnt.getNome_banco());
        stmt.setInt(2,banEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return banEnt;
    }

   public List<Banco> listar(Banco banEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Banco> bank = new ArrayList<>();
        
        String sql = "select * from bancos where nome_banco like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + banEnt.getNome_banco()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
                Banco ban = new Banco(
                rs.getInt(1),
                rs.getString(2)
               
            );
            // adiciona o usu à lista de usus
            bank.add(ban);
        }
        
        rs.close();
        stmt.close();
        return bank;
   
   }
}
