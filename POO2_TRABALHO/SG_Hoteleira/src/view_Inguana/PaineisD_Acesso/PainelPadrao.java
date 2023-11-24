package view_Inguana.PaineisD_Acesso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PainelPadrao extends JPanel {
    
    public JLabel lbMessage;
    public String name;
    
    public PainelPadrao(String name) {
        setLayout(null);
        setBackground(Color.red);
        lbMessage = new JLabel();
        Font fonte = new Font("Segoe UI", Font.BOLD, 18);
        lbMessage.setForeground(Color.BLACK);
        lbMessage.setBounds(0, 0, 900, 500);
        lbMessage.setText(name);
        
    }
    
}
