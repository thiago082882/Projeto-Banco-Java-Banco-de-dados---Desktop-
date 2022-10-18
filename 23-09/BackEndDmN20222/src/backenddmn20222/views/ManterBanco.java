/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.views;

import backenddmn20222.controllers.ControllerBanco;
import backenddmn20222.models.beans.Banco;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class ManterBanco {
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
        Banco ban = new Banco(nome);
        ControllerBanco contpes = new ControllerBanco();
        ban = contpes.inserir(ban);
        JOptionPane.showMessageDialog(null,ban.toString());
    }

 public static void alterar() throws SQLException, ClassNotFoundException {
   int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome_banco = JOptionPane.showInputDialog("NOME");
        Banco ban = new Banco(id,nome_banco);
        ControllerBanco contban = new ControllerBanco();
        ban = contban.alterar(ban);
        JOptionPane.showMessageDialog(null,ban.toString());
    }
    public static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Banco ban = new Banco(id);
        ControllerBanco contban = new ControllerBanco();
        ban = contban.buscar(ban);
        JOptionPane.showMessageDialog(null,ban.toString());
    }
    public static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Banco ban = new Banco(id);
        ControllerBanco contpes = new ControllerBanco();
        ban = contpes.excluir(ban);
        JOptionPane.showMessageDialog(null,ban.toString());
    }
    public static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Banco ban = new Banco(nome);
        ControllerBanco contban = new ControllerBanco();
        List<Banco> listaBan = contban.listar(ban);
        for (Banco banSaida : listaBan) {
            JOptionPane.showMessageDialog(null,banSaida.toString());
        }
    }
}
