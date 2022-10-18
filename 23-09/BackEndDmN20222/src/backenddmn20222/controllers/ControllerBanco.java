/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Banco;
import backenddmn20222.models.daos.DaoBanco;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thiag
 */
public class ControllerBanco {
    
    
    static DaoBanco daoBac;
    
    public Banco inserir (Banco ban) throws SQLException, ClassNotFoundException {
        daoBac = new DaoBanco(); 
        return daoBac.inserir(ban);
    }
    public Banco alterar (Banco ban) throws SQLException, ClassNotFoundException {
        daoBac = new DaoBanco(); 
        return daoBac.alterar(ban);
    }
    public List<Banco> listar (Banco ban) throws SQLException, ClassNotFoundException {
        daoBac = new DaoBanco(); 
        return daoBac.listar(ban);
    }
    public Banco excluir(Banco ban) throws SQLException, ClassNotFoundException {
        daoBac = new DaoBanco(); 
        return daoBac.excluir(ban);
    }
    public Banco buscar(Banco ban) throws SQLException, ClassNotFoundException {
        daoBac = new DaoBanco(); 
        return daoBac.buscar(ban);
    }
    
}
