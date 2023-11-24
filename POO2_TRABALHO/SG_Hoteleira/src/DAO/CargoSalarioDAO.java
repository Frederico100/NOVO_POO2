package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.Conectar;
import Model.CargoSalario;
import Model.Cliente;

public class CargoSalarioDAO {

    public void insert(CargoSalario cargo_salario) {
        Connection con = Conectar.getConectar();
        String sql = "INSERT INTO cargo_salarios(salario,cargo) VALUES(?,?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setDouble(1, cargo_salario.getSalario());
            st.setString(2, cargo_salario.getCargo());
            st.execute();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "cadastro com sucesso da categoria salario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao cadastrar cargo salario.....  " + ex.getMessage());

        }
    }

    public void Update(CargoSalario cargo_salario) {
        Connection con = Conectar.getConectar();
        String sql = "UPDATE cargo_salarios SET salario=?,cargo=? WHERE codigo=?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
           

            st.setDouble(1, cargo_salario.getSalario());
            st.setString(2, cargo_salario.getCargo());
            st.setInt(3, cargo_salario.getCodigo_cargo());
            st.execute();
            st.close();
            JOptionPane.showMessageDialog(null, " Dados da tabela Cargo Salario actualizados com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Erro ao actualizar a tabela cargo Salario"+ ex);

        }

    }

    public void delete(CargoSalario cargo_salario) {
        Connection conn = Conectar.getConectar();
        String sql = "DELETE  FROM cargo_salarios  WHERE codigo=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cargo_salario.getCodigo_cargo());
            ps.executeUpdate();
            ps.close();
            conn.close();

            JOptionPane.showMessageDialog(null, "excluido com sucesso o registro invocado na tabela Cargo Salario");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o registro" + ex);

        }

    }

    public ArrayList<CargoSalario> select() {
       ArrayList<CargoSalario> lista = new ArrayList<CargoSalario>();

        String sql = "SELECT * FROM cargo_salarios ";

        Connection con = Conectar.getConectar();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet result = st.executeQuery();

            while (result.next()) {
                CargoSalario cargo_salario = new CargoSalario();
                cargo_salario.setCodigo_cargo(result.getInt("codigo"));

                cargo_salario.setSalario(result.getDouble("salario"));

                cargo_salario.setCargo(result.getString("cargo"));

                lista.add(cargo_salario);
            }
            con.close();
            result.close();
              JOptionPane.showMessageDialog(null, " Busca feita com sucesso na tabela Cargo Salario" );
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, " Erro ao procurar Cargo Salario" + ex);

        }

        return lista;
    }

}
