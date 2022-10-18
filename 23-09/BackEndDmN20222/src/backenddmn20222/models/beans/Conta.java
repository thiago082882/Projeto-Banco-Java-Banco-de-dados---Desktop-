/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.beans;


import java.sql.Date;

/**
 *
 * @author thiag
 */
public class Conta {
    
        private int id;
        private int agencia;
	private int numero;
        private Date data_abertura;
        private String status;
	private double saldo;
	public Cliente cliente;

    public Conta(int id) {
        this.id = id;
    }

    public Conta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
    }
    
     public Conta(int agencia, int numero, Date data_abertura, String status, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.data_abertura = data_abertura;
        this.status = status;
        this.saldo = saldo;
    }
      public Conta(int id, int agencia, int numero, Date data_abertura, String status,double saldo) {
          this.id = id;
        this.agencia = agencia;
        this.numero = numero;
        this.data_abertura = data_abertura;
        this.status = status;
        this.saldo = saldo;
      
    }

    public Conta(int agencia, int numero, Date data_abertura, String status, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.data_abertura = data_abertura;
        this.status = status;
        this.saldo = saldo;
        this.cliente = cliente;
    }

   
    public Conta(int id, int agencia, int numero, Date data_abertura, String status, double saldo, Cliente cliente) {
        this.id = id;
        this.agencia = agencia;
        this.numero = numero;
        this.data_abertura = data_abertura;
        this.status = status;
        this.saldo = saldo;
        this.cliente = cliente;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(Byte agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", agencia=" + agencia + ", numero=" + numero + ", data_abertura=" + data_abertura + ", status=" + status + ", saldo=" + saldo + '}';
    }


    
        
        
}
