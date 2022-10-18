/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Conta;
import backenddmn20222.models.daos.DaoConta;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thiag
 */
public class ControllerConta {
        static DaoConta daoCont;
    
    public Conta inserir (Conta cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta(); 
        return daoCont.inserir(cont);
    }
    public Conta alterar (Conta cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta(); 
        return daoCont.alterar(cont);
    }
    public List<Conta> listar (Conta cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta(); 
        return daoCont.listar(cont);
    }
    public Conta excluir(Conta cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta(); 
        return daoCont.excluir(cont);
    }
    public Conta buscar(Conta cont) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta(); 
        return daoCont.buscar(cont);
    }
}
