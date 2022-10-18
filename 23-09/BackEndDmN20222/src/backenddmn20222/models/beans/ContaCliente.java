/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.beans;

/**
 *
 * @author thiag
 */
public class ContaCliente {
    private int id;
       private int idCliente;
       private int idConta;
       private Conta con;
       private Cliente cli;

    public ContaCliente(int id) {
        this.id = id;
    }

    public ContaCliente(int idCliente, int idConta) {
        this.idCliente = idCliente;
        this.idConta = idConta;
    }

    public ContaCliente(int id, int idCliente, int idConta) {
        this.id = id;
        this.idCliente = idCliente;
        this.idConta = idConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public Conta getCon() {
        return con;
    }

    public void setCon(Conta con) {
        this.con = con;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    @Override
    public String toString() {
        return "ContaCliente{" + "id=" + id + ", idCliente=" + idCliente + ", idConta=" + idConta + '}';
    }

   

   
     
}
