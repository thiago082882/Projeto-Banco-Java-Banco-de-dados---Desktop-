/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerContaCliente;
import backenddmn20222.models.beans.ContaCliente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class ManterContaCliente {
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
        int idConta = Integer.parseInt(JOptionPane.showInputDialog("IDCONTA"));
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("IDCLIENTE"));
       ContaCliente concliEnt = new ContaCliente(idConta,idCliente);
        ControllerContaCliente contConCli = new ControllerContaCliente();
        ContaCliente concliSaida = contConCli.inserir(concliEnt);
        JOptionPane.showMessageDialog(null, concliSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
     int idConta = Integer.parseInt(JOptionPane.showInputDialog("IDCONTA"));
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("IDCLIENTE"));
       ContaCliente concliEnt = new ContaCliente(idConta,idCliente);
        ControllerContaCliente contConCli = new ControllerContaCliente();
        ContaCliente concliSaida = contConCli.alterar(concliEnt);
        JOptionPane.showMessageDialog(null, concliSaida.toString());
    }

    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
         ContaCliente concliEnt = new ContaCliente(id);
        ControllerContaCliente contConCli = new ControllerContaCliente();
        ContaCliente concliSaida = contConCli.buscar(concliEnt);
        JOptionPane.showMessageDialog(null, concliSaida.toString());
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException {
          int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
         ContaCliente concliEnt = new ContaCliente(id);
        ControllerContaCliente contConCli = new ControllerContaCliente();
        ContaCliente concliSaida = contConCli.excluir(concliEnt);
        JOptionPane.showMessageDialog(null, concliSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
       int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ContaCliente concliEnt = new ContaCliente(id);
        ControllerContaCliente contConCli = new ControllerContaCliente();
        List<ContaCliente> listaContaCliente = contConCli.listar(concliEnt);
        for(ContaCliente conCli: listaContaCliente) {
            JOptionPane.showMessageDialog(null, conCli.toString());
            JOptionPane.showMessageDialog(null, conCli.getCon().toString());
            JOptionPane.showMessageDialog(null, conCli.getCli().toString());
        }
    }  
}
