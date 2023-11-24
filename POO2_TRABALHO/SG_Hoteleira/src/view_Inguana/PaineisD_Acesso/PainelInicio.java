package view_Inguana.PaineisD_Acesso;

import Acessorios.Header;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelInicio extends JPanel {

    private JLabel l, l2;

    public PainelInicio() {
        setLayout(null);
        setBackground(new Color(89, 13, 165));

        l = new JLabel();
        l2 = new JLabel("Hotel Imperios");

        // Configuração da fonte
        Font fonte = new Font("Lucida Calligraphy", Font.BOLD, 100);
        l2.setFont(fonte);
        l2.setForeground(new Color(247, 250, 255));

        // Configuração do texto centralizado
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setVerticalAlignment(JLabel.CENTER);

        l2.setBackground(Color.WHITE);
        l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/imperiosb.png")));
        l.setBounds(200, -10, 800, 600);

        // Definindo as dimensões do JLabel l2
        l2.setBounds(80, 580, 1080, 100);

        add(l);
        add(l2);
    }
}
