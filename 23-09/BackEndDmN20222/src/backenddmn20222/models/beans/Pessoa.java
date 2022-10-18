/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.beans;

/**
 *
 * @author lab04aluno
 */
public class Pessoa {
    
    protected int id;
    protected String nome;
    protected String rg;
    protected String cpf;
    protected String email;

    // buscar/excluir usuario pela chave pk
    public Pessoa(int id) {
        this.id = id;
    }
    // listar pessoas por nome
    public Pessoa(String nome) {
        this.nome = nome;
    }
    // para inserir pessoa
    public Pessoa(String nome, String rg, String cpf, String email) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
    }
    // para alterar dados de pessoa
    public Pessoa(int id, String nome, String rg, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
    }
    
     public Pessoa(int id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // get e set para valorização de variaveis
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // para impressao
    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", email=" + email + '}';
    
    }
    
}

    
    
    