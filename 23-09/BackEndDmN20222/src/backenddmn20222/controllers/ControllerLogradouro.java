/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Logradouro;
import backenddmn20222.models.daos.DaoLogradouro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thiag
 */
public class ControllerLogradouro {
    
    static DaoLogradouro daoLog;
    
    public Logradouro inserir (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.inserir(log);
    }
    public Logradouro alterar (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.alterar(log);
    }
    public List<Logradouro> listar (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.listar(log);
    }
    public Logradouro excluir(Logradouro log) throws SQLException, ClassNotFoundException {
       daoLog = new DaoLogradouro(); 
        return daoLog.excluir(log);
    }
    public Logradouro buscar(Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.buscar(log);
    }
    
}
