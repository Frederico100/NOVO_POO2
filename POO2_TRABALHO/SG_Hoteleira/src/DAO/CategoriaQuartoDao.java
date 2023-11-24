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
import Model.CategoriaQuarto;
import Model.Cliente;

public class CategoriaQuartoDao {

    public void insert(CategoriaQuarto categoria_quarto) {
        Connection con = Conectar.getConectar();
        String sql = "INSERT INTO categoria_quarto(tipo_de_cama,preco_normal,preco_de_reserva,tipoQuarto) VALUES(?,?,?,?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, categoria_quarto.getTipo_de_cama());
            st.setDouble(2, categoria_quarto.getPreco_normal());
            st.setDouble(3, categoria_quarto.getPreco_reserva());
            st.setString(4, categoria_quarto.getTipoQuarto());
            //st.set(4, categoria_quarto.isTipoQuarto());

            st.executeUpdate();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso dos Dados da Categoria Quarto");
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, " Erro ao cadastrar a Categoria  Quarto, ERRO.....: +"+ex);

        }
    }

  public void Update(CategoriaQuarto categoriaQuarto) {
        Connection con = Conectar.getConectar();
        String sql = "UPDATE categoria_quarto SET tipo_de_cama=?,preco_normal=?,preco_de_reserva=?, tipoQuarto=? WHERE codigo=?";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, categoriaQuarto.getTipo_de_cama());

            st.setInt(2, categoriaQuarto.getPreco_normal());

            st.setInt(3, categoriaQuarto.getPreco_reserva());
            st.setString(4, categoriaQuarto.getTipoQuarto());
            st.setInt(5, categoriaQuarto.getCodigo());

            st.executeUpdate();
            st.close();

            JOptionPane.showMessageDialog(null, " Actualizacao da Categoria  Quarto feita com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Erro ao actualizar a Categoria  Quarto " + "Erro ......:" + ex);

        }

    }


     public void delete(CategoriaQuarto categoriaQuarto) {
        Connection conn = Conectar.getConectar();
        String sql = "DELETE  FROM categoria_quarto  WHERE codigo=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, categoriaQuarto.getCodigo());
         
            ps.executeUpdate();
            ps.close();
               JOptionPane.showMessageDialog(null, " Excluido com sucesso dados invocados no Registro Categoria Quarto");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a categoria Quarto"+"Erro......" + ex);

        }

    }

    public ArrayList<CategoriaQuarto> select() {
        ArrayList<CategoriaQuarto> lista = new ArrayList<CategoriaQuarto>();

        String sql = "SELECT * FROM categoria_quarto ";

        Connection con = Conectar.getConectar();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet result = st.executeQuery();

           while (result.next()) {
                CategoriaQuarto categoria_quarto = new CategoriaQuarto();

                categoria_quarto.setCodigo(result.getInt("codigo"));

                categoria_quarto.setTipo_de_cama(result.getString("tipo_de_cama"));

                categoria_quarto.setPreco_normal(result.getInt("preco_normal"));

                categoria_quarto.setPreco_reserva(result.getInt("preco_de_reserva"));

                categoria_quarto.setTipoQuarto(result.getString("tipoQuarto"));

                lista.add(categoria_quarto);
                System.out.println(categoria_quarto);
            }
            con.close();
           JOptionPane.showMessageDialog(null, "  Dados da Categoria Quarto foram selecionados com sucesso ");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, " Erro ao Selecionar dados da Categoria Quarto " +"/n Erro :..." + ex);

        }

        return lista;
    }

}
