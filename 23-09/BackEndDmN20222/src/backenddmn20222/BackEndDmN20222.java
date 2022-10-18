/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddmn20222;

import backenddmn20222.views.ManterBanco;
import backenddmn20222.views.ManterBancoConta;
import backenddmn20222.views.ManterBancoLogradouro;
import backenddmn20222.views.ManterCliente;
import backenddmn20222.views.ManterConta;
import backenddmn20222.views.ManterContaCliente;
import backenddmn20222.views.ManterLogradouro;
import backenddmn20222.views.ManterPessoa;
import backenddmn20222.views.ManterUsuario;
import backenddmn20222.views.ManterUsuarioPessoa;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author lab04aluno
 */
public class BackEndDmN20222 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException, ParseException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Pessoa \n 3 - UsuarioPessoa \n 4 - Banco \n 5 - Conta \n 6 - Cliente \n 7 - logradouro\n 8 - BancoConta\n 9 - BancoLogradouro\n 10 - ContaCliente\n";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario.menu();
                break;
            case 2:
                ManterPessoa.menu();
                break;
            case 3:
                ManterUsuarioPessoa.menu();
                break;
                
            case 4: 
                ManterBanco.menu();
                break;
                
            case 5:
                ManterConta.menu();
                break;
                
            case 6:
                ManterCliente.menu();
                break;
                
            case 7:
                ManterLogradouro.menu();
                break;
                
            case 8:
                ManterBancoConta.menu();
                break;
                
            case 9:
                ManterBancoLogradouro.menu();
                break;
                
            case 10:
                ManterContaCliente.menu();
                break;
                
            default:
                System.out.println("Opção inválido");
        }
    }
    
}