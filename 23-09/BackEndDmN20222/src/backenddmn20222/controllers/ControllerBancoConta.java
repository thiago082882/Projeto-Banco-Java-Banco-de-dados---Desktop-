/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Banco;
import backenddmn20222.models.beans.BancoConta;
import backenddmn20222.models.beans.Conta;
import backenddmn20222.models.daos.DaoBancoConta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiag
 */
public class ControllerBancoConta {
    
    ControllerBanco contBan;
    ControllerConta contCon;
    DaoBancoConta daoBanCon;
    
    public BancoConta inserir(BancoConta banconEnt) throws SQLException, ClassNotFoundException {
        daoBanCon = new DaoBancoConta();
        banconEnt = daoBanCon.inserir(banconEnt);
        return banconEnt;
    }

    public BancoConta alterar(BancoConta banconEnt) throws SQLException, ClassNotFoundException {
        daoBanCon = new DaoBancoConta();
       banconEnt= daoBanCon.alterar(banconEnt);
        return banconEnt;
    }

    public List<BancoConta> listar(BancoConta banconEnt) throws SQLException, ClassNotFoundException {
        daoBanCon = new DaoBancoConta();

        List<BancoConta> listaUsuPesAux = daoBanCon.listar(banconEnt);

        List<BancoConta> listaUsuPesRetorno = new ArrayList<>();
                
        for(BancoConta bancon : listaUsuPesAux) {        
            listaUsuPesRetorno.add(buscar(bancon));
        }

        return listaUsuPesRetorno;
    }

    public BancoConta excluir(BancoConta banconEnt) throws SQLException, ClassNotFoundException {
        daoBanCon= new DaoBancoConta();
        banconEnt = daoBanCon.excluir(banconEnt);
        return banconEnt;
    }

    public BancoConta buscar(BancoConta banconEnt) throws SQLException, ClassNotFoundException {

        daoBanCon = new DaoBancoConta();
        BancoConta banconSaida = daoBanCon.buscar(banconEnt);

        Banco banEnt = new Banco(banconSaida.getIdBanco());
        contBan = new ControllerBanco();
        banconSaida.setBan(contBan.buscar(banEnt));
        
        Conta conEnt = new Conta(banconSaida.getIdConta());
        contCon = new ControllerConta();
        banconSaida.setCon(contCon.buscar(conEnt));

        return banconSaida;
    }

}
