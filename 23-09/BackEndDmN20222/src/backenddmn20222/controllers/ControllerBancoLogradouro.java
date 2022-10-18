/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.controllers;

import backenddmn20222.models.beans.Banco;
import backenddmn20222.models.beans.BancoLogradouro;
import backenddmn20222.models.beans.Logradouro;
import backenddmn20222.models.daos.DaoBancoLogradouro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiag
 */
public class ControllerBancoLogradouro {
        ControllerBanco contBan;
    ControllerLogradouro contLog;
    DaoBancoLogradouro daoBanLog;
    
    public BancoLogradouro inserir(BancoLogradouro banlogEnt) throws SQLException, ClassNotFoundException {
        daoBanLog = new DaoBancoLogradouro();
        banlogEnt = daoBanLog.inserir(banlogEnt);
        return banlogEnt;
    }

    public BancoLogradouro alterar(BancoLogradouro banlogEnt) throws SQLException, ClassNotFoundException {
        daoBanLog = new DaoBancoLogradouro();
       banlogEnt= daoBanLog.alterar(banlogEnt);
        return banlogEnt;
    }

    public List<BancoLogradouro> listar(BancoLogradouro banlogEnt) throws SQLException, ClassNotFoundException {
        daoBanLog = new DaoBancoLogradouro();

        List<BancoLogradouro> listaUsuPesAux = daoBanLog.listar(banlogEnt);

        List<BancoLogradouro> listaUsuPesRetorno = new ArrayList<>();
                
        for(BancoLogradouro banlog : listaUsuPesAux) {        
            listaUsuPesRetorno.add(buscar(banlog));
        }

        return listaUsuPesRetorno;
    }

    public BancoLogradouro excluir(BancoLogradouro banlogEnt) throws SQLException, ClassNotFoundException {
       daoBanLog= new DaoBancoLogradouro();
        banlogEnt = daoBanLog.excluir(banlogEnt);
        return banlogEnt;
    }

    public BancoLogradouro buscar(BancoLogradouro banlogEnt) throws SQLException, ClassNotFoundException {

        daoBanLog = new DaoBancoLogradouro();
        BancoLogradouro banlogSaida = daoBanLog.buscar(banlogEnt);

        Banco banEnt = new Banco(banlogSaida.getIdBanco());
        contBan = new ControllerBanco();
        banlogSaida.setBan(contBan.buscar(banEnt));
        
        Logradouro logEnt = new Logradouro(banlogSaida.getIdLogradouro());
        contLog = new ControllerLogradouro();
        banlogSaida.setLog(contLog.buscar(logEnt));

        return banlogSaida;
    }
}
