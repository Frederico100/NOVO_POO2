package teste;

import DAO.CargoSalarioDAO;
import DAO.FuncionarioDAO;
import Model.CargoSalario;
import Model.Funcionario;

public class teste {

    public static void main(String[] args) {
        Funcionario f = new Funcionario();

        CargoSalario cs = new CargoSalario();
        
        cs.setCargo("Recepcionista");
        cs.setSalario(400);
        cs.setCodigo_cargo(1);
        CargoSalarioDAO csdao = new CargoSalarioDAO();

        csdao.insert(cs);
        // f.setBi("124");
        // f.setNome("Antonio Colaco");
        // f.setIdade(25);
        // f.setSexo("Masculino");
        // f.setTelefone("875597700");
        // f.setEndereco("Maputo");

        // f.setAno_de_adimissao("2022");
        // f.setSenha("900700");
        // f.setEmail("antonio@gmail.com");
        // f.setCodigo_cargo(2);

        // Funcionario_dao fdao = new Funcionario_dao();

        // fdao.insert(f);
        System.out.println();

    }
}