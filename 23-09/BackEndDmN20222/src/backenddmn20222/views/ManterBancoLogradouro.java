/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerBancoLogradouro;
import backenddmn20222.models.beans.BancoLogradouro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class ManterBancoLogradouro {
    
        public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    
    public static void inserir() throws SQLException, ClassNotFoundException {
        int idBanco = Integer.parseInt(JOptionPane.showInputDialog("IDBANCO"));
        int idLogradouro = Integer.parseInt(JOptionPane.showInputDialog("IDLOGRADOURO"));
       BancoLogradouro banlogEnt = new  BancoLogradouro(idBanco,idLogradouro);
        ControllerBancoLogradouro contBanLog = new ControllerBancoLogradouro();
        BancoLogradouro banlogSaida = contBanLog.inserir(banlogEnt);
        JOptionPane.showMessageDialog(null, banlogSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
     int idBanco = Integer.parseInt(JOptionPane.showInputDialog("IDBANCO"));
        int idLogradouro = Integer.parseInt(JOptionPane.showInputDialog("IDLOGRADOURO"));
       BancoLogradouro banlogEnt = new  BancoLogradouro(idBanco,idLogradouro);
        ControllerBancoLogradouro contBanLog = new ControllerBancoLogradouro();
        BancoLogradouro banlogSaida = contBanLog.alterar(banlogEnt);
        JOptionPane.showMessageDialog(null, banlogSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
         BancoLogradouro banlogEnt = new  BancoLogradouro(id);
        ControllerBancoLogradouro contBanLog = new ControllerBancoLogradouro();
        BancoLogradouro banlogSaida = contBanLog.buscar(banlogEnt);
        JOptionPane.showMessageDialog(null, banlogSaida.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
         int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
         BancoLogradouro banlogEnt = new  BancoLogradouro(id);
        ControllerBancoLogradouro contBanLog = new ControllerBancoLogradouro();
        BancoLogradouro banlogSaida = contBanLog.excluir(banlogEnt);
        JOptionPane.showMessageDialog(null, banlogSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
       int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        BancoLogradouro usulogEnt = new BancoLogradouro(id);
        ControllerBancoLogradouro contBanCon = new ControllerBancoLogradouro();
        List<BancoLogradouro> listaBancoLogradouro = contBanCon.listar(usulogEnt);
        for(BancoLogradouro banLog: listaBancoLogradouro) {
            JOptionPane.showMessageDialog(null, banLog.toString());
            JOptionPane.showMessageDialog(null, banLog.getBan().toString());
            JOptionPane.showMessageDialog(null, banLog.getLog().toString());
        }
    }  
    
    
}
