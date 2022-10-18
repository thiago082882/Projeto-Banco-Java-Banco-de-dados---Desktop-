/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerConta;
import backenddmn20222.models.beans.Conta;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class ManterConta {
     public static void menu() throws SQLException, ClassNotFoundException, ParseException {
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

    public static void inserir() throws SQLException, ClassNotFoundException, ParseException {
       
        int agencia= Integer.parseInt(JOptionPane.showInputDialog("AGENCIA"));
        int numero = Integer.parseInt(JOptionPane.showInputDialog("NUMERO"));
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      Date data_abertura = formato.parse(JOptionPane.showInputDialog("DATA_ABERTURA"));
        String status = JOptionPane.showInputDialog("STATUS");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("SALDO"));
        Conta con = new Conta(agencia,numero,new java.sql.Date(data_abertura.getTime()),status,saldo);
        ControllerConta contcon = new ControllerConta();
        con = contcon.inserir(con);
        JOptionPane.showMessageDialog(null,con.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException, ParseException {
         int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
         int agencia= Integer.parseInt(JOptionPane.showInputDialog("AGENCIA"));
        int numero = Integer.parseInt(JOptionPane.showInputDialog("NUMERO"));
   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
   Date data_abertura = formato.parse(JOptionPane.showInputDialog("DATA_ABERTURA"));
        String status = JOptionPane.showInputDialog("STATUS");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("SALDO"));
            Conta con = new Conta(id,agencia,numero,new java.sql.Date(data_abertura.getTime()),status,saldo);
        ControllerConta contcon = new ControllerConta();
        con = contcon.alterar(con);
        JOptionPane.showMessageDialog(null,con.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
         int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Conta con = new Conta(id);
        ControllerConta contcon = new ControllerConta();
        con = contcon.buscar(con);
        JOptionPane.showMessageDialog(null,con.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        
        
          int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Conta con = new Conta(id);
        ControllerConta contcon = new ControllerConta();
        con = contcon.excluir(con);
        JOptionPane.showMessageDialog(null,con.toString());
   
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        int agencia= Integer.parseInt(JOptionPane.showInputDialog("AGENCIA"));
        Conta con = new Conta(agencia,0);
        ControllerConta contCon = new ControllerConta();
        List<Conta> listaCon = contCon.listar(con);
        for (Conta conSaida : listaCon) {
            JOptionPane.showMessageDialog(null,conSaida.toString());
        }
    }
}
