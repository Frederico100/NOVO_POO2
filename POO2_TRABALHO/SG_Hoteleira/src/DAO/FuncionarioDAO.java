package DAO;

import Conexao.Conectar;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class FuncionarioDAO {

    public void insert(Funcionario funcionario) {
        Connection con = Conectar.getConectar();
        String sql = "INSERT INTO funcionario(Bi,nome,idade,sexo,Telefone,endereco,ano_de_admissao,senha,email,Codigo_Cargo) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);
           
            st.setString(1, funcionario.getBi());
            st.setString(2, funcionario.getNome());
            st.setInt(3, funcionario.getIdade());
            st.setString(4, String.valueOf(funcionario.getSexo()));
            st.setString(5, funcionario.getTelefone());
            st.setString(6, funcionario.getEndereco());
            st.setString(7, funcionario.getAno_de_adimissao());
            st.setString(8, null);
            st.setString(9, null);
            st.setInt(10, funcionario.getCargo().getCodigo_cargo());

            st.execute();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "funcionario cadastrado com sucesso ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro AO cadastrar funcionario " + ex.getMessage());

        }

    }

    public void Update(Funcionario funcionario) {
        Connection con = Conectar.getConectar();
        String sql = "UPDATE funcionario SET Nome=?,Idade=?,sexo=?, Telefone=?, endereco=?,ano_de_admissao=?, senha=?, email=?, Codigo_Cargo=?  WHERE Bi=?";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, funcionario.getNome());
            st.setInt(2, funcionario.getIdade());
            st.setString(3, String.valueOf(funcionario.getSexo()));
            st.setString(4, funcionario.getTelefone());
            st.setString(5, funcionario.getEndereco());
            st.setString(6, funcionario.getAno_de_adimissao());
            st.setString(7, null);
            st.setString(8, null);
            
            st.setInt(9, funcionario.getCargo().getCodigo_cargo());
            st.setString(10, funcionario.getBi());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, " Actualizacao com sucesso dos dados do funcionario");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Erro ao actualizar dados do funcionario " + ex);

        }

    }

    public void delete(Funcionario funcionario) {
        Connection conn = Conectar.getConectar();
        String sql = "DELETE  FROM funcionario where   Bi=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getBi());
            ps.execute();
            JOptionPane.showMessageDialog(null, "excluido com sucesso o registro invocado do funcionario");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o registro invocado do funcionario" + ex);

        }

    }

    public ArrayList<Funcionario> select() {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

        String sql = "SELECT * from funcionario,cargo_salarios WHERE Codigo_Cargo=codigo";

        Connection con = Conectar.getConectar();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet result = st.executeQuery();

            while (result.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setBi(result.getString("Bi"));
                funcionario.setNome(result.getString("Nome"));

                funcionario.setIdade(result.getInt("Idade"));

                funcionario.setSexo(result.getString("sexo").charAt(0));
                funcionario.setTelefone(result.getString("Telefone"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setAno_de_adimissao(result.getString("ano_de_admissao"));

               // funcionario.setSenha(result.getString("senha"));

               // funcionario.setEmail(result.getString("email"));

               CargoSalario cargo = new CargoSalario();
               cargo.setCodigo_cargo(Integer.parseInt(result.getString("codigo")));
               cargo.setSalario(Double.parseDouble(result.getString("salario")));
               cargo.setCargo(result.getString("cargo"));
                
               funcionario.setCargo(cargo);

                lista.add(funcionario);
            }
            con.close();
            st.close();
             JOptionPane.showMessageDialog(null, " Dados do Funcionario selecionados com sucesso");
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, " Erro ao buscar dados do funcionario "+ ex);

        }

        return lista;
    }

}
