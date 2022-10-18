/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerLogradouro;
import backenddmn20222.models.beans.Logradouro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class ManterLogradouro {
    
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
        String endereco = JOptionPane.showInputDialog("ENDERECO");
        String cep = JOptionPane.showInputDialog("CEP");
        String complemento = JOptionPane.showInputDialog("COMPLEMENTO");
        Logradouro log = new Logradouro(endereco,cep,complemento);
        ControllerLogradouro contlog = new ControllerLogradouro();
        log = contlog.inserir(log);
        JOptionPane.showMessageDialog(null,log.toString());
    }

    public static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String endereco = JOptionPane.showInputDialog("NOME");
        String cep = JOptionPane.showInputDialog("RG");
        String complemento = JOptionPane.showInputDialog("CPF");
        Logradouro log = new Logradouro(id,endereco,cep,complemento);
        ControllerLogradouro contlog = new ControllerLogradouro();
        log = contlog.alterar(log);
        JOptionPane.showMessageDialog(null,log.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro log = new Logradouro(id);
        ControllerLogradouro contlog = new ControllerLogradouro();
        log = contlog.buscar(log);
        JOptionPane.showMessageDialog(null,log.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro log = new Logradouro(id);
        ControllerLogradouro contlog = new ControllerLogradouro();
        log = contlog.excluir(log);
        JOptionPane.showMessageDialog(null,log.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String endereco = JOptionPane.showInputDialog("ENDERECO");
        Logradouro log = new Logradouro(endereco);
        ControllerLogradouro contlog = new ControllerLogradouro();
        List<Logradouro> listaLog = contlog.listar(log);
        for (Logradouro logSaida : listaLog) {
            JOptionPane.showMessageDialog(null,logSaida.toString());
        }
    }
    
}
