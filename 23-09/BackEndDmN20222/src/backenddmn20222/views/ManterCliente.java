/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerCliente;
import backenddmn20222.models.beans.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author thiag
 */
public class ManterCliente {
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
        String nome = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String telefone =JOptionPane.showInputDialog("TELEFONE");
        String email = JOptionPane.showInputDialog("EMAIL");
        String sexo = JOptionPane.showInputDialog("SEXO");
        Cliente cli = new Cliente(nome,cpf,telefone,email,sexo);
        ControllerCliente contcli = new ControllerCliente();
        cli = contcli.inserir(cli);
        JOptionPane.showMessageDialog(null,cli.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String telefone =JOptionPane.showInputDialog("TELEFONE");
        String email = JOptionPane.showInputDialog("EMAIL");
        String sexo = JOptionPane.showInputDialog("SEXO");
        Cliente cli = new Cliente(id,nome,cpf,telefone,email,sexo);
        ControllerCliente contcli = new ControllerCliente();
        cli = contcli.inserir(cli);
        JOptionPane.showMessageDialog(null,cli.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cliente cli = new Cliente(id);
        ControllerCliente contcli = new ControllerCliente();
        cli = contcli.buscar(cli);
        JOptionPane.showMessageDialog(null,cli.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        
        
         int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cliente cli = new Cliente(id);
        ControllerCliente contcli = new ControllerCliente();
        cli = contcli.excluir(cli);
        JOptionPane.showMessageDialog(null,cli.toString());
   
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Cliente cli = new Cliente(nome);
        ControllerCliente contCli = new ControllerCliente();
        List<Cliente> listaCli = contCli.listar(cli);
        for (Cliente cliSaida : listaCli) {
            JOptionPane.showMessageDialog(null,cliSaida.toString());
        }
    }

    
}
