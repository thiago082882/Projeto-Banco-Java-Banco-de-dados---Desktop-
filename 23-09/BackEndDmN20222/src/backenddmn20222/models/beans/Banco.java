/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiag
 */
public class Banco {
    private int id;
    private String nome_banco;
	private Logradouro endereco;
	private List<Conta> contas = new ArrayList<Conta>();

    public Banco(int id) {
        this.id = id;
    }
        
        
    public Banco(String nome_banco) {
        this.nome_banco = nome_banco;
    }
    
  public Banco(int id, String nome_banco) {
        this.id = id;
        this.nome_banco=nome_banco;
       
        
    }

//    public Banco(String nome_banco, Logradouro endereco,List<Conta> contas) {
//       this.nome_banco = nome_banco;
//        this.endereco = endereco;
//        this.contas= contas;
//      
// 
//       
//    }
//     public Banco(int id, String nome_banco, Logradouro endereco,List<Conta> contas) {
//        this.id = id;
//         this.nome_banco = nome_banco;
//        this.endereco = endereco;
//        this.contas=  contas;
//    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_banco() {
        return nome_banco;
    }

    public void setNome_banco(String nome_banco) {
        this.nome_banco = nome_banco;
    }

    public Logradouro getEndereco() {
        return endereco;
    }

    public void setEndereco(Logradouro endereco) {
        this.endereco = endereco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "Banco{" + "id=" + id + ", nome_banco=" + nome_banco + '}';
    }
    
}
