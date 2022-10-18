/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.BancoLogradouro;
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
public class DaoBancoLogradouro {

  private final Connection c;
    
    public DaoBancoLogradouro() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }


    public BancoLogradouro excluir(BancoLogradouro banlogEnt) throws SQLException{
        String sql = "delete from bancos_logradouros WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,banlogEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return banlogEnt;
    }
    
    public BancoLogradouro buscar(BancoLogradouro banlogEnt) throws SQLException{
        String sql = "select * from bancos_contas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,banlogEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
           BancoLogradouro banlogSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                banlogSaida = new BancoLogradouro(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return banlogSaida;
   }

    public BancoLogradouro inserir(BancoLogradouro banlogEnt) throws SQLException{
        String sql = "insert into bancos_logradouros " + " (idBanco, idLogradouro)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, banlogEnt.getIdBanco());
        stmt.setInt(2, banlogEnt.getIdLogradouro());
        

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            banlogEnt.setId(id);
        }
        stmt.close();
        return banlogEnt;
    }

    public BancoLogradouro alterar(BancoLogradouro banlogEnt) throws SQLException{
        String sql = "UPDATE bancos_logradouros SET idBanco = ?, idLogradouro = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,banlogEnt.getIdBanco());
        stmt.setInt(2,banlogEnt.getIdLogradouro());
        stmt.setInt(3,banlogEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return banlogEnt;
    }

   public List<BancoLogradouro> listar(BancoLogradouro banlogEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<BancoLogradouro> banlogs = new ArrayList<>();
        
        String sql = "select * from bancos_logradouros where id like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + banlogEnt.getId()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
           BancoLogradouro bancon = new BancoLogradouro(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3));
            // adiciona o usu à lista de usus
            banlogs.add(bancon);
        }
        
        rs.close();
        stmt.close();
        return banlogs;
   
   }
    
}
