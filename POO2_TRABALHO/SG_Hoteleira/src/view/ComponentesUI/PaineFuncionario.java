package view.ComponentesUI;

import Ferrament_Componet.TextFieldModificado;
import Ferrament_Componet.RoundedBorder;
import Ferrament_Componet.JButtonModificado;
import java.awt.*;
import javax.swing.*;

public class PaineFuncionario extends JPanel{

    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, lbFuncionario, lbMae; // Criação das labels
    private JPanel painel1, painel2, painel3, painelDacoplagem;
    private TextFieldModificado tfnome, tfIdade, tfBI, tfContacto, tfRua, tfFiliacaoP, tfFiliacaoM;
    private JButtonModificado bCadastro, bSalvar, bEditar, bApagar; // Criação de variaveis de instancia da classe JButtonModificado que cria botoes customizados
    private JComboBox cbSexo, cbIdade, cbCidade;
    private JTable tabela;

    public PaineFuncionario() {
        setLayout(new CardLayout());
        setBackground(Color.WHITE);

        painel1 = new JPanel();
        painel2 = new JPanel();
        painel3 = new JPanel();
        painelDacoplagem = new JPanel();
        painel2.setLayout(new GridLayout());
        // --- Criando Instâncias das Label's
        l1 = new JLabel("Nome");
        l2 = new JLabel("Idade");
        l3 = new JLabel("BI");
        l4 = new JLabel("Contacto"); // Telefone
        l5 = new JLabel("Cidade");
        l6 = new JLabel("Sexo");
        l7 = new JLabel("Cadastro");
        lbFuncionario = new JLabel("Funcionário");

        Font fonte = new Font("Segoe UI", Font.BOLD, 15);

        l1.setFont(fonte);
        l2.setFont(fonte);
        l3.setFont(fonte);
        l4.setFont(fonte);
        l5.setFont(fonte);
        l6.setFont(fonte);
        l7.setFont(new Font("Segoe UI", Font.BOLD, 35));
        lbFuncionario.setFont(new Font("Segoe UI", Font.BOLD, 18));

        // Definido as Cores das Labels
        // --- Inicío do Agrupamento ----
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        l7.setForeground(Color.WHITE);
        lbFuncionario.setForeground(Color.WHITE);

        // Agrupando as JLabels & Dimensões Com as suas respectivas coordenadas
        // --- Inicío do Agrupamento ----
        l1.setBounds(20, 120, 100, 30);
        l2.setBounds(20, 160, 100, 30);
        l3.setBounds(20, 200, 100, 30);
        l4.setBounds(1095, 120, 100, 30);
        l5.setBounds(1110, 160, 100, 30);
        l6.setBounds(1123, 200, 100, 30);
        l7.setBounds(20, 20, 650, 80);
        lbFuncionario.setBounds(240, 26, 650, 80);
        // --- Fim do Agrupamento ---

        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/nome_usuario.png")));
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/idade.png")));
        l3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/bi.png")));
        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/contacto.png")));
        l5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/cidade.png")));
        l6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/sexo.png")));
        l7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Icones/Registragem.png")));

        // Agrupando as Instancias das TextFields
        // --- Inicío do Agrupamento ----
        tfnome = new TextFieldModificado(ALLBITS);
        tfIdade = new TextFieldModificado(ALLBITS);
        tfBI = new TextFieldModificado(ALLBITS);
        tfContacto = new TextFieldModificado(ALLBITS);
        // --- Fim de Agrupamento ---

        // Definindo Coordenadas das TextFieldsModificadas
        tfnome.setBounds(115, 120, 380, 30);
        tfBI.setBounds(115, 200, 380, 30);
        tfContacto.setBounds(702, 120, 380, 30);

        // Instanciamento da Tabela
        tabela = new JTable();

        // Agrupando as Instancias das Botões
        // --- Inicío do Agrupamento ----
        bCadastro = new JButtonModificado();
        bSalvar = new JButtonModificado();
        bEditar = new JButtonModificado();
        bApagar = new JButtonModificado();
        // --- Fim de Agrupamento ---

        // Agrupando as Instancias das JComboBox's
        // --- Inicío do Agrupamento ----
        cbSexo = new JComboBox();
        cbIdade = new JComboBox();
        cbCidade = new JComboBox();
        // --- Fim de Agrupamento ---

        //--- Inicío---
        // Criação da JComboBox para o atributo Sexo
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Masculino");
        comboBoxModel.addElement("Feminino");

        cbSexo = new JComboBox<>(comboBoxModel);
        // Configure a borda personalizada para o JComboBox
        cbSexo.setBorder(new RoundedBorder(15)); // Ajuste o raio conforme desejado
        cbSexo.setBackground(Color.WHITE);
        cbSexo.setBounds(702, 200, 380, 30); // Posicione o JComboBox conforme necessário
        //--- Fim ---

        //--- Inicío--- Criação da JComboBox para o atributo Idade
        DefaultComboBoxModel<String> comboBoxModelo = new DefaultComboBoxModel<>();
        comboBoxModelo.addElement("18");
        comboBoxModelo.addElement("19");
        comboBoxModelo.addElement("20");
        comboBoxModelo.addElement("21");
        comboBoxModelo.addElement("22");

        cbIdade = new JComboBox<>(comboBoxModelo);
        // Configure a borda personalizada para o JComboBox
        cbIdade.setBorder(new RoundedBorder(15)); // Ajuste o raio conforme desejado
        cbIdade.setBackground(Color.WHITE); // Cor do ComboBox
        cbIdade.setBounds(115, 160, 380, 30); // Posicione o JComboBox conforme necessário
        //--- Fim ---

        //--- Inicío--- Criação da JComboBox para o atributo Cidade
        DefaultComboBoxModel<String> comboBoxModell = new DefaultComboBoxModel<>();
        comboBoxModell.addElement("Cidade De Maputo");
        comboBoxModell.addElement("Cidade De Matola");
        comboBoxModell.addElement("Cidade De Xai-Xai");
        comboBoxModell.addElement("Cidade De Vilanculos");
        comboBoxModell.addElement("Cidade Da Beira");
        comboBoxModell.addElement("Cidade Da Sofala");

        cbCidade = new JComboBox<>(comboBoxModell);
        // Configure a borda personalizada para o JComboBox
        cbCidade.setBorder(new RoundedBorder(15)); // Ajuste o raio conforme desejado
        cbCidade.setBackground(Color.WHITE); // Cor do ComboBox
        cbCidade.setBounds(702, 160, 380, 30); // Posicione o JComboBox conforme necessário
        //--- Fim ---

        painel1.setLayout(null);
        painelDacoplagem.setLayout(new BorderLayout());

        painel1.setBackground(Color.DARK_GRAY);
        painel2.setBackground(new Color(252, 252, 252));
        painelDacoplagem.setBackground(new Color(255, 255, 255));

        // Definindo as dimensões do painel1
        painel1.setPreferredSize(new Dimension(0, 320));
        //painel2.setPreferredSize(new Dimension(0, 330));

        // Agrupando os Botoes
        // --- Inicío de Agrupamento ---
        bCadastro.setBackground(new Color(0, 255, 0));
        bCadastro.setForeground(Color.BLACK);
        bCadastro.setText("Cadastrar");
        bCadastro.setBounds(290, 260, 120, 30);
        // -----------------------------------------------
        bSalvar.setBackground(new Color(0, 255, 0));
        bSalvar.setForeground(Color.BLACK);
        bSalvar.setText("Salvar");
        bSalvar.setBounds(450, 260, 120, 30);
        // -----------------------------------------------
        bEditar.setBackground(new Color(0, 255, 0));
        bEditar.setForeground(Color.BLACK);
        bEditar.setText("Editar");
        bEditar.setBounds(610, 260, 120, 30);
        // -----------------------------------------------
        bApagar.setBackground(new Color(0, 255, 0));
        bApagar.setForeground(Color.BLACK);
        bApagar.setText("Apagar");
        bApagar.setBounds(770, 260, 120, 30);
        // --- Fim de Agrupamento ---

        // Agrupando as TextFields Com as suas respectivas coordenadas
        // --- Inicío do Agrupamento ----
        // --- Fim do Agrupamento ---
        // Criação da JTable
        // --- Inicío de Código ---
        tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null}

                },
                new String[]{
                    "Nome", "Idade", "BI", "Sexo", "Contacto", "Cidade", "Endereço", "Email"
                }
        ));

        //tabela = new JTable(modelo);
        tabela.setBackground(Color.WHITE);
        tabela.setForeground(new java.awt.Color(0, 0, 255)); // Foreground Cor azul
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(253, 224, 224));
        tabela.setBorder(null);

        JScrollPane scrollPane = new JScrollPane(tabela);

        painel2.add(scrollPane);
        painel1.add(painel2, BorderLayout.CENTER);
        // --- Fim de Código ---

        painel1.add(l1);
        painel1.add(l2);
        painel1.add(l3);
        painel1.add(l4);
        painel1.add(l5);
        painel1.add(l6);
        painel1.add(l7);
        painel1.add(lbFuncionario);

        painel1.add(cbIdade); // Adicione o JComboBox ao painel1
        painel1.add(cbSexo); // Adicione o JComboBox ao painel1
        painel1.add(cbCidade); // Adicione o JComboBox ao painel1

        painel1.add(bCadastro);
        painel1.add(bSalvar);
        painel1.add(bEditar);
        painel1.add(bApagar);

        painel1.add(tfnome);
        painel1.add(tfBI);
        painel1.add(tfContacto);

        painelDacoplagem.add(painel1, BorderLayout.NORTH);
        painelDacoplagem.add(painel2, BorderLayout.CENTER);
        add(painelDacoplagem);
    }
    
    public static void main(String[] args) {
       
        JFrame jf = new JFrame();
        jf.add( new PaineFuncionario());
        jf.setVisible(true);
    }

}
