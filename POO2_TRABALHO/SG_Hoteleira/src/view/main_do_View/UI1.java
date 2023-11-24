package view.main_do_View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.ComponentesUI.PaineFuncionario;
import view.ComponentesUI.PainelInicio;
import view.ComponentesUI.PainelOpCadastro;
import view.ComponentesUI.PainelRegistroCliente;

import view.ComponentesUI.PainelRegistroFunc;

public class UI1 extends JFrame {

    private JPanel painel, painel2, painel3; // Criação dos paineis
    private JButton l1, l2, l3, l4; // Criação das labels
    Tratadora trata;

    // setBackground(new Color(205, 1, 10)); Vermelho Escuro
    public UI1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PainelInicio pi = new PainelInicio();
        PaineFuncionario pf = new PaineFuncionario();
        PainelRegistroFunc pr = new PainelRegistroFunc();
        PainelOpCadastro poc = new PainelOpCadastro();
        PainelRegistroCliente prc = new PainelRegistroCliente();
        trata = new Tratadora();

        painel = new JPanel();
        painel2 = new JPanel();
        painel3 = new JPanel();

        l1 = new JButton("Inicio");
        l2 = new JButton("Cadastro");
        l2.addActionListener(trata);
        l3 = new JButton("Registros");
        l4 = new JButton("Serviços");

        l2.setBackground(new Color(45, 38, 80));
        l2.setBorder(null);

        Font fonte = new Font("Segoe UI", Font.BOLD, 14);

        painel.setLayout(new BorderLayout());
        painel2.setLayout(new BorderLayout());

        painel.setBackground(new Color(255, 255, 255));
        painel2.setBackground(new Color(35, 25, 45));
        painel3.setBackground(new Color(45, 38, 80));

        l1.setForeground(Color.WHITE);
        l1.setFont(fonte);
        l1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        l1.setFocusPainted(false);
        l1.setBorder(null);
        l1.setBackground(new Color(45, 38, 80));

        l2.setForeground(Color.WHITE);
        l2.setFont(fonte);
        l2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        l2.setFocusPainted(false);
        l2.setBorder(null);
        l2.setBackground(new Color(45, 38, 80));

        l3.setForeground(Color.WHITE);
        l3.setFont(fonte);
        l3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        l3.setFocusPainted(false);
        l3.setBorder(null);
        l3.setBackground(new Color(45, 38, 80));

        l4.setForeground(Color.WHITE);
        l4.setFont(fonte);
        l4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        l4.setFocusPainted(false);
        l4.setBorder(null);
        l4.setBackground(new Color(45, 38, 80));

        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/inicio.png")));
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/cadastro.png")));
        l3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/historico.png")));
        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/servicos.png")));

        painel2.setPreferredSize(new Dimension(0, 100));
        painel3.setPreferredSize(new Dimension(150, 0));

        l1.setPreferredSize(new Dimension(150, 35));
        l2.setPreferredSize(new Dimension(150, 35));
        l3.setPreferredSize(new Dimension(150, 35));
        l4.setPreferredSize(new Dimension(150, 35));

        l2.setBounds(0, 36, 150, 30);
        l3.setBounds(0, 37, 150, 30);
        l4.setBounds(0, 38, 150, 30);

        painel.add(painel2, BorderLayout.NORTH);
        painel.add(painel3, BorderLayout.WEST);
        painel.add(pf, BorderLayout.CENTER);
        painel.add(pr, BorderLayout.CENTER);
        painel.add(poc, BorderLayout.CENTER);
        //painel.add(prc, BorderLayout.CENTER);

        painel3.add(l1);
        painel3.add(l2);
        painel3.add(l3);
        painel3.add(l4);

        add(painel);

        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class Tratadora implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == l2) {

            }
        }

    }

}
