package Model;

/**
 *
 * @author Paulo
 */
public class Pessoa {
    private String bi;
    private String nome;
    private int idade;
    private char sexo;
    private String endereco;
    private String telefone;

    public Pessoa(String bi, String nome, int idade, char sexo, String endereco, String telefone) {
        this.bi = bi;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    Pessoa(){}
    

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "bi=" + bi + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }

    

}