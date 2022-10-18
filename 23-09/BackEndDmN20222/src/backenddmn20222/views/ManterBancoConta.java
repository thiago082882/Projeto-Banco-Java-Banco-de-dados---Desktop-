/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerBancoConta;
import backenddmn20222.models.beans.BancoConta;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class ManterBancoConta {
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
        int idConta = Integer.parseInt(JOptionPane.showInputDialog("IDCONTA"));
       BancoConta banconEnt = new BancoConta(idBanco,idConta);
        ControllerBancoConta contBanCon = new ControllerBancoConta();
        BancoConta banconSaida = contBanCon.inserir(banconEnt);
        JOptionPane.showMessageDialog(null, banconSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
     int idBanco = Integer.parseInt(JOptionPane.showInputDialog("IDBANCO"));
        int idConta = Integer.parseInt(JOptionPane.showInputDialog("IDCONTA"));
       BancoConta banconEnt = new BancoConta(idBanco,idConta);
        ControllerBancoConta contBanCon = new ControllerBancoConta();
        BancoConta banconSaida = contBanCon.alterar(banconEnt);
        JOptionPane.showMessageDialog(null, banconSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        BancoConta banconEnt = new BancoConta(id);
        ControllerBancoConta contBanCon = new ControllerBancoConta();
        BancoConta banconSaida = contBanCon.buscar(banconEnt);
        JOptionPane.showMessageDialog(null, banconSaida.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
         int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        BancoConta banconEnt = new BancoConta(id);
        ControllerBancoConta contBanCon = new ControllerBancoConta();
        BancoConta banconSaida = contBanCon.excluir(banconEnt);
        JOptionPane.showMessageDialog(null, banconSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
       int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        BancoConta banconEnt = new BancoConta(id);
        ControllerBancoConta contBanCon = new ControllerBancoConta();
        List<BancoConta> listaBancoConta = contBanCon.listar(banconEnt);
        for(BancoConta banCon: listaBancoConta) {
            JOptionPane.showMessageDialog(null, banCon.toString());
            JOptionPane.showMessageDialog(null, banCon.getBan().toString());
            JOptionPane.showMessageDialog(null, banCon.getCon().toString());
        }
    }  
    
}
