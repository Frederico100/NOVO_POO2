package Conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class Conectar {

    private static final String url = "jdbc:mysql://localhost/sistema_gestao_hoteleira";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConectar() {
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Falha ao conectar a base de dados");

        }

        return con;

    }

}
