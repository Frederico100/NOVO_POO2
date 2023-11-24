package view.ComponentesUI;

import Ferrament_Componet.TextFieldModificado;
import Ferrament_Componet.JButtonModificado;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.image.ImageObserver.ALLBITS;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelRegistroCliente extends JPanel{

    private JPanel painel1, painel2, painel3;
    private JButtonModificado btPesquisar, btAtualizar;
    private TextFieldModificado tfSearch;
    private JLabel l1, l2, l3, l4, lbCliente; // Criação das labels
    private JTable tabela;

    public PainelRegistroCliente() {
        setLayout(new CardLayout());
        setBackground(Color.DARK_GRAY);

        painel1 = new JPanel();
        painel2 = new JPanel();
        painel3 = new JPanel();

        tabela = new JTable();

        painel1.setLayout(new BorderLayout());
        painel2.setLayout(null);
        painel3.setLayout(new GridLayout());

        l1 = new JLabel("Pesquisar");
        l2 = new JLabel("Registros");
        lbCliente = new JLabel("Cliente");
        lbCliente.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lbCliente.setForeground(Color.WHITE);
        lbCliente.setBounds(275, 5, 650, 80);

        btPesquisar = new JButtonModificado();

        Font fonte = new Font("Segoe UI", Font.BOLD, 15);

        l1.setFont(fonte);
        l1.setForeground(Color.WHITE);
        l1.setBounds(40, 85, 150, 30);
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/search.png")));

        l2.setFont(new Font("Segoe UI", Font.BOLD, 40));
        l2.setForeground(Color.WHITE);
        l2.setBounds(40, 10, 280, 55);
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/pesquisa_lista.png")));

        tfSearch = new TextFieldModificado(ALLBITS);
        tfSearch.setBounds(150, 85, 380, 30);

        btPesquisar.setText("Pesquisar");
        btPesquisar.setBounds(535, 85, 120, 30);
        btPesquisar.setPreferredSize(new Dimension(40, 40));

        painel1.setBackground(new Color(254, 255, 255));
        painel2.setBackground(Color.DARK_GRAY);
        painel3.setBackground(new Color(255, 255, 255));

        // Criação da JTable
        // --- Inicío de Código ---
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}

                },
                new String[]{
                    "Nome", "Idade", "BI", "Língua", "Sexo", "Contacto", "Cidade", "Endereço", "Email"
                }
        ));
        // Customização da tabela Design
        //tabela = new JTable(modelo);
        tabela.setBackground(Color.WHITE);
        tabela.setForeground(new java.awt.Color(0, 0, 255)); // Foreground Cor azul
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(253, 224, 224));
        tabela.setBorder(null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        // --- Fim ---

        painel2.setPreferredSize(new Dimension(0, 140));
        painel2.add(l1);
        painel2.add(l2);
        painel2.add(lbCliente);
        painel2.add(tfSearch);
        painel2.add(btPesquisar);
        painel3.add(scrollPane);

        painel1.add(painel2, BorderLayout.NORTH);
        painel1.add(painel3, BorderLayout.CENTER);

        add(painel1);
    }

}
