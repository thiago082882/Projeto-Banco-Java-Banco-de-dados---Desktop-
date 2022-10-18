/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Cliente;
import backenddmn20222.models.daos.DaoCliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thiag
 */
public class ControllerCliente {
    

    static DaoCliente daoCli;
    
    public Cliente inserir (Cliente cli) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente(); 
        return daoCli.inserir(cli);
    }
    public Cliente alterar (Cliente cli) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente(); 
        return daoCli.alterar(cli);
    }
    public List<Cliente> listar (Cliente cli) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente(); 
        return daoCli.listar(cli);
    }
    public Cliente excluir(Cliente cli) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente(); 
        return daoCli.excluir(cli);
    }
    public Cliente buscar(Cliente cli) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente(); 
        return daoCli.buscar(cli);
    }

}
    

