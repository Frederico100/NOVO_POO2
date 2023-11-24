package DAO;

import Conexao.Conectar;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class ClienteDAO {

    public void insert(Cliente cliente) {
        Connection con = Conectar.getConectar();
        String sql = "INSERT INTO cliente(Bi,nome,idade,sexo,Telefone,data_do_registro,endereco,Bi_Funcionario)  VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            // falta programar o codigo aque
            System.out.println(cliente);
            st.setString(1, cliente.getBi());
            st.setString(2, cliente.getNome());
            st.setInt(3, cliente.getIdade());
            st.setString(4, String.valueOf(cliente.getSexo()));
            st.setString(5, cliente.getTelefone());
            st.setString(7, cliente.getEndereco());
            
          
       
            st.setDate(6, new java.sql.Date(cliente.getData_do_registro().getTime()));
            st.setInt(8, cliente.getBiAtendente());
            st.execute();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Hospede " + cliente.getNome() + " cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao cadastrar o hospede..." + ex);

        }

    }

    public void Update(Cliente cliente) {
       System.out.println("teste: "+cliente);
        Connection con = Conectar.getConectar();
        String sql = "UPDATE quarto SET Nome=?,Idade=?,Sexo=?, Telefone=?,endereco=?, data_do_registro=?,Bi_Funcionario=? WHERE Bi=?";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, cliente.getNome());

            st.setInt(2, cliente.getIdade());
            
            st.setString(3, String.valueOf(cliente.getSexo()));
            
            st.setString(4, cliente.getTelefone());

            st.setString(5, cliente.getEndereco());
            
            st.setDate(6, new java.sql.Date(cliente.getData_do_registro().getTime()));
            
            st.setInt(7, cliente.getBiAtendente());
            
            st.setString(8, cliente.getBi());
            
            st.executeUpdate();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, " Actualizar com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Erro AO actualizar" + ex);

        }

    }

    public void delete(Cliente cliente) {
        Connection con= Conectar.getConectar();
        String sql = "DELETE  FROM quarto WHERE Bi=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getBi());
            ps.executeUpdate();
            ps.close();
            con.close();
             JOptionPane.showMessageDialog(null, "Excluido com sucesso o registro");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o registro"+ex);

        }

    }

    public ArrayList<Cliente> select() {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        String sql = "select bi,nome,idade,sexo, telefone,endereco, data_do_registro, Bi_Funcionario  from cliente";

        Connection con = Conectar.getConectar();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet result = st.executeQuery();

            while (result.next()) {
                Cliente cliente = new Cliente();

                cliente.setBi(result.getString("Bi"));

                cliente.setNome(result.getString("Nome"));

                cliente.setIdade(result.getInt("Idade"));

                cliente.setSexo(result.getString("Sexo").charAt(0));

                cliente.setTelefone(result.getString("Telefone"));

                cliente.setEndereco(result.getString("endereco"));
          
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                cliente.setData_do_registro(result.getDate("data_do_registro"));

                cliente.setBiAtendente(result.getInt("Bi_Funcionario"));
               
                lista.add(cliente);
             //   System.out.println(cliente);
            }
            con.close();
            result.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, " Erro ao buscar cliente" + ex);

        }

        return lista;
    }

    public static void main(String[] args) {
        Date d = new Date();
         DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println( df.format(d));
        String da = df.format(d);
//System.out.println(df.format(cliente.getData_do_registro()));
    }
}
