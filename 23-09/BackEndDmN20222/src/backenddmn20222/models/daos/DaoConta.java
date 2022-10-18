/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.daos;
import backenddmn20222.models.beans.Conta;
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
public class DaoConta {
    private final Connection c;
    
    public DaoConta() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    
}
    
     public Conta excluir(Conta conEnt) throws SQLException{
        String sql = "delete from contas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,conEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return conEnt;
    }
      public Conta buscar(Conta contEnt) throws SQLException{
        String sql = "select * from contas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,contEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Conta contSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                contSaida = new Conta(
                        
                    rs.getInt(1),
                    rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getDouble(6));
                    
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return contSaida;
   }
      
      public Conta inserir(Conta conEnt) throws SQLException{
        String sql = "insert into contas " + " (agencia, numero,data_abertura,status,saldo)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,conEnt.getAgencia());
        stmt.setInt(2,conEnt.getNumero());
        stmt.setDate(3,conEnt.getData_abertura());
        stmt.setString(4,conEnt.getStatus());
        stmt.setDouble(5,conEnt.getSaldo());
        


        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            conEnt.setId(id);
        }
        stmt.close();
        return conEnt;
    }

    public Conta alterar(Conta conEnt) throws SQLException{
        String sql = "UPDATE contas SET agencia = ?, numero = ?, data_abertura = ?,status=?,saldo=? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
       stmt.setInt(1,conEnt.getAgencia());
        stmt.setInt(2,conEnt.getNumero());
        stmt.setDate(3,conEnt.getData_abertura());
        stmt.setString(4,conEnt.getStatus());
        stmt.setDouble(5,conEnt.getSaldo());
        stmt.setInt(6,conEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return conEnt;
    }

   public List<Conta> listar(Conta conEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Conta> listCon = new ArrayList<>();
        
        String sql = "select * from contas where agencia like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + conEnt.getAgencia()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Conta con = new Conta(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getDate(4),
                   rs.getString(5),
                    rs.getDouble(6));
            // adiciona o usu à lista de usus
            listCon.add(con);
        }
        
        rs.close();
        stmt.close();
        return listCon;
   
   }
}
