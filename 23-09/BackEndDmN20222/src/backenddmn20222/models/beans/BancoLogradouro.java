/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmn20222.models.beans;

/**
 *
 * @author thiag
 */
public class BancoLogradouro {
    private int id;
   private int idBanco;
  private int idLogradouro;
 private Banco ban;
    private Logradouro log;

    public BancoLogradouro(int id) {
        this.id = id;
    }

    public BancoLogradouro(int idBanco,int idLogradouro) {
        this.idBanco = idBanco;
         this.idLogradouro = idLogradouro;
    }

    public BancoLogradouro(int id,int idBanco,int idLogradouro) {
        this.id = id;
        this.idBanco = idBanco;
          this.idLogradouro = idLogradouro;
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
    
    public int getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }


    public Banco getBan() {
        return ban;
    }

    public void setBan(Banco ban) {
        this.ban = ban;
    }

    public Logradouro getLog() {
        return log;
    }

    public void setLog(Logradouro log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return "BancoLogradouro{" + "id=" + id + ", idLogradouro=" + idLogradouro + ", idBanco=" + idBanco + '}';
    }
    


     
}
