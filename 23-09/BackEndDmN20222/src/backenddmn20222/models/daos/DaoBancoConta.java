/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.daos;

import backenddmn20222.models.beans.BancoConta;
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
public class DaoBancoConta {

    private final Connection c;
    
    public DaoBancoConta() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }


    public BancoConta excluir(BancoConta banconEnt) throws SQLException{
        String sql = "delete from bancos_contas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,banconEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return banconEnt;
    }
    
    public BancoConta buscar(BancoConta banconEnt) throws SQLException{
        String sql = "select * from bancos_contas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,banconEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
           BancoConta banconSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                banconSaida = new BancoConta(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return banconSaida;
   }

    public BancoConta inserir(BancoConta banconEnt) throws SQLException{
        String sql = "insert into bancos_contas " + " (idBanco, idConta)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, banconEnt.getIdBanco());
        stmt.setInt(2, banconEnt.getIdConta());
        

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            banconEnt.setId(id);
        }
        stmt.close();
        return banconEnt;
    }

    public BancoConta alterar(BancoConta banconEnt) throws SQLException{
        String sql = "UPDATE bancos_contas SET idBanco = ?, idConta = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,banconEnt.getIdBanco());
        stmt.setInt(2,banconEnt.getIdConta());
        stmt.setInt(3,banconEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return banconEnt;
    }

   public List<BancoConta> listar(BancoConta banconEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<BancoConta> bancons = new ArrayList<>();
        
        String sql = "select * from bancos_contas where id like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + banconEnt.getId()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
           BancoConta bancon = new BancoConta(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3));
            // adiciona o usu à lista de usus
            bancons.add(bancon);
        }
        
        rs.close();
        stmt.close();
        return bancons;
   
   }

    
}
