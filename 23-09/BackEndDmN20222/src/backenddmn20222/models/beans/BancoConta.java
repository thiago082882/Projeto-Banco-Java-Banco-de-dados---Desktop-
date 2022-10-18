/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.beans;

/**
 *
 * @author thiag
 */
public class BancoConta {
    private int id;
     private int idBanco;
     private int idConta;
      private Banco ban;
    private Conta con;

    public BancoConta(int id) {
        this.id = id;
    }

    public BancoConta(int idBanco, int idConta) {
        this.idBanco = idBanco;
        this.idConta = idConta;
    }

    public BancoConta(int id, int idBanco, int idConta) {
        this.id = id;
        this.idBanco = idBanco;
        this.idConta = idConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public Banco getBan() {
        return ban;
    }

    public void setBan(Banco ban) {
        this.ban = ban;
    }

    public Conta getCon() {
        return con;
    }

    public void setCon(Conta con) {
        this.con = con;
    }

    @Override
    public String toString() {
        return "BancoConta{" + "id=" + id + ", idBanco=" + idBanco + ", idConta=" + idConta + '}';
    }

   
    
}
