/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Cliente;
import backenddmn20222.models.beans.Conta;
import backenddmn20222.models.beans.ContaCliente;
import backenddmn20222.models.daos.DaoContaCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiag
 */
public class ControllerContaCliente {

      ControllerConta contCon;
    ControllerCliente contCli;
    DaoContaCliente daoConCli;
    
    public ContaCliente inserir(ContaCliente concliEnt) throws SQLException, ClassNotFoundException {
        daoConCli = new DaoContaCliente();
        concliEnt = daoConCli.inserir(concliEnt);
        return concliEnt;
    }

    public ContaCliente alterar(ContaCliente concliEnt) throws SQLException, ClassNotFoundException {
            daoConCli = new DaoContaCliente();
        concliEnt = daoConCli.alterar(concliEnt);
        return concliEnt;
    }

    public List<ContaCliente> listar(ContaCliente concliEnt) throws SQLException, ClassNotFoundException {
        daoConCli = new DaoContaCliente();

        List<ContaCliente> listaConCliAux = daoConCli.listar(concliEnt);

        List<ContaCliente> listaConCliRetorno = new ArrayList<>();
                
        for(ContaCliente concli : listaConCliAux) {        
            listaConCliRetorno.add(buscar(concli));
        }

        return listaConCliRetorno;
    }

    public ContaCliente excluir(ContaCliente concliEnt) throws SQLException, ClassNotFoundException {
       daoConCli= new DaoContaCliente();
       concliEnt = daoConCli.excluir(concliEnt);
        return concliEnt;
    }

    public ContaCliente buscar(ContaCliente concliEnt) throws SQLException, ClassNotFoundException {

        daoConCli = new DaoContaCliente();
        ContaCliente concliSaida = daoConCli.buscar(concliEnt);

        
        Conta conEnt = new Conta(concliSaida.getIdConta());
        contCon = new ControllerConta();
        concliSaida.setCon(contCon.buscar(conEnt));
        
         Cliente cliEnt = new Cliente (concliSaida.getIdCliente());
        contCli = new ControllerCliente();
        concliSaida.setCli(contCli.buscar(cliEnt));

        return concliSaida;
    }

    
}
