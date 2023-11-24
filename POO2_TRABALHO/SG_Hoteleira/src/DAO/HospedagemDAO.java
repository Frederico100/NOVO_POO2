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
import Model.Hospedagem;

/**
 *
 * @author Paulo
 */
public class HospedagemDAO {

    public void insert(Hospedagem hospedagem) {
        Connection con = Conectar.getConectar();
        String sql = "INSERT INTO hospedagem_Reserva(dataInicio,dataFim,valor_apagar,numero_quarto,bi_cliente) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);

           // st.setInt(1, hospedagem.getId());
            st.setDate(1, new java.sql.Date(hospedagem.getDataInicio().getTime()));
            st.setDate(2, new java.sql.Date(hospedagem.getDataFim().getTime()));
            st.setFloat(3, hospedagem.getValorApagar());
            st.setInt(4, hospedagem.getNuquarto());
            st.setString(5, hospedagem.getBi_cliente());
            st.executeUpdate();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao cadastrar" + ex);

        }
        try {
            PreparedStatement st2 = con.prepareStatement(sql);
        } catch (SQLException ex) {

        }

    }

    public void Update(Hospedagem hospedagem) {
        Connection con = Conectar.getConectar();
        String sql = "UPDATE hospedagem_reserva set dataInicio=?,dataFim=?,valor_apagar=?,numero_quarto=?,bi_cliente=? where  id=?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setInt(6, hospedagem.getId());
            st.setDate(1, new java.sql.Date(hospedagem.getDataInicio().getTime()));
            st.setDate(2, new java.sql.Date(hospedagem.getDataFim().getTime()));
            st.setFloat(3, hospedagem.getValorApagar());
            st.setInt(4, hospedagem.getNuquarto());
            st.setString(5, hospedagem.getBi_cliente());
            st.executeUpdate();
            
            st.close();
            con.close();
            con.close();
            JOptionPane.showMessageDialog(null, " Dado da hospedagem actualizado com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Erro ao actualizar o dado da hospedagem invocado"+ex);

        }

    }

    public void delete(Hospedagem hospedagem) {
        Connection conn = Conectar.getConectar();
        String sql = "DELETE  FROM  hospedagem_reserva  WHERE id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("idddd.."+ hospedagem.getId());
            ps.setInt(1, hospedagem.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            JOptionPane.showMessageDialog(null, " Dado invocado da hospedagem excluido com sucesso" );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o registro invocado da hospedagem");

        }

    }

    public ArrayList<Hospedagem> select() {
        ArrayList<Hospedagem> lista = new ArrayList<>();

        String sql = "SELECT * FROM hospedagem_reserva ";

        Connection con = Conectar.getConectar();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet result = st.executeQuery();

            while (result.next()) {
                Hospedagem hospedagem = new Hospedagem();
               
              
                CargoSalario cargo_salario = new CargoSalario();
                
                hospedagem.setId(result.getInt("id"));
                hospedagem.setDataInicio(result.getDate("dataInicio"));
                hospedagem.setDataFim(result.getDate("dataFim"));
                hospedagem.setValorApagar(result.getFloat("valor_apagar"));
                hospedagem.setNuquarto(result.getInt("numero_quarto"));
                hospedagem.setBi_cliente(result.getString("bi_cliente"));
             
                lista.add(hospedagem);
                System.out.println("hospedagem");
            }
            con.close();
            st.close();
            con.close();
             JOptionPane.showMessageDialog(null, " Dados da hospedagem selecionados com sucesso" );
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, " Erro ao buscar dados da hospedagem" +ex);

        }

        return lista;
    }

}
