package Model;

import DAO.FuncionarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class Funcionario extends Pessoa {

    private String ano_de_adimissao;
    

    private CargoSalario cargo;

    public String getAno_de_adimissao() {
        return ano_de_adimissao;
    }

    public void setAno_de_adimissao(String ano_de_adimissao) {
        this.ano_de_adimissao = ano_de_adimissao;
    }

    public Funcionario(String bi, String nome, int idade, char sexo, String telefone, String endereco, String ano, CargoSalario cargo) {
        super(bi,nome,idade,sexo,endereco,telefone);
        this.ano_de_adimissao=ano;
        this.cargo = cargo;
    }
    
    public Funcionario(){
    super();
    }

        
   
    public CargoSalario getCargo() {
        return cargo;
    }

    public void setCargo(CargoSalario cargo) {
        this.cargo = cargo;
    }

    
    public void add(Funcionario funcionario){
        new FuncionarioDAO().insert(funcionario);
    }
   
    public ArrayList<Funcionario> consult(){
        return new FuncionarioDAO().select();
    }
    
    public void update(Funcionario funcionario){
        new FuncionarioDAO().Update(funcionario);
    }
    public void delete(Funcionario funcionario){
        new FuncionarioDAO().delete(funcionario);
    }
    

}
