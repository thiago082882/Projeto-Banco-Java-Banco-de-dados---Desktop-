
package backenddmn20222.models.beans;

/**
 *
 * @author thiag
 */
public class Cliente  {
    
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String sexo;

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, String cpf, String telefone, String email, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
    }

    public Cliente(int id, String nome, String cpf, String telefone, String email, String sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", sexo=" + sexo + '}';
    }

    
    
}
