package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Conexao.Conectar;
import Model.CategoriaQuarto;
import Model.Quarto;

/**
 *
 * @author Paulo
 */
public class QuartoDAO {

    public void insert(Quarto quarto) {
        Connection con = Conectar.getConectar();
        // deve se alterar esse comando sql
        String sql = "INSERT INTO quarto(disponivel,ocupado,andar,Telefone,codigoCategoria) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);

          //  st.setInt(1, quarto.getNumero());
            st.setString(1, quarto.getDisponibilidade());
            st.setString(2, quarto.getOcupado());
            st.setInt(3, quarto.getAndar());
            st.setString(4, quarto.getTelefone());
            st.setInt(5, quarto.getCategoria().getCodigo());

            st.executeUpdate();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao cadastrar  " + ex);

        }

    }

    public void Update(Quarto quarto) {
        Connection con = Conectar.getConectar();
        // deve se alterar esse comando sql
        String sql = "UPDATE quarto SET disponivel=?,ocupado=?,andar=?, Telefone=?,codigoCategoria=? WHERE numero=?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
                        st.setString(1, quarto.getDisponibilidade());
            st.setString(2, quarto.getOcupado());
            st.setInt(3, quarto.getAndar());
            st.setString(4, quarto.getTelefone());
            st.setInt(5, quarto.getCategoria().getCodigo());
            st.setInt(6, quarto.getNumero());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, " Actualizar com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " erro aO actualizar...." + ex);

        }

    }

    public void delete(Quarto quarto) {
        System.out.println("quartio daod no dao"+ quarto);
        
       System.out.println(quarto);
        Connection conn = Conectar.getConectar();
        System.out.println(".....numero e"+ quarto.getNumero());
        String sql = "DELETE  FROM quarto  WHERE numero=?";

        try {
            PreparedStatement st = conn.prepareStatement(sql);
       
            st.setInt(1, quarto.getNumero());
            
            st.executeUpdate();
            st.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Removeu - se o quarto com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o registro" + ex);

        }

    }

    public ArrayList<Quarto> select() {
        ArrayList<Quarto> lista = new ArrayList<Quarto>();

        String sql = " SELECT * FROM quarto,  categoria_quarto  where codigo = codigoCategoria";

        Connection con = Conectar.getConectar();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet result = st.executeQuery();

            while (result.next()) {
              Quarto quarto = new Quarto();
                quarto.setNumero(result.getInt("numero"));
                quarto.setDisponibilidade(result.getString("disponivel"));
                quarto.setOcupado(result.getString("Ocupado"));
                quarto.setAndar(result.getInt("andar"));
                quarto.setTelefone(result.getString("Telefone"));
                
                
                CategoriaQuarto categoria = new CategoriaQuarto();
                categoria.setCodigo(result.getInt("codigo"));
                categoria.setPreco_normal(result.getInt("preco_normal"));
                categoria.setPreco_reserva(result.getInt("preco_de_reserva"));
                categoria.setTipoQuarto(result.getString("tipoQuarto"));
                categoria.setTipo_de_cama(result.getString("tipo_de_cama"));
                
                quarto.setCategoria(categoria);

                lista.add(quarto);
            }
            
            con.close();
            result.close();
            
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, " Erro ao procurar o quarto" + ex);

        }

        return lista;
    }
}
