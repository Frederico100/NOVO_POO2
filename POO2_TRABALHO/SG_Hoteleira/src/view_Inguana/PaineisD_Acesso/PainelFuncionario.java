package view_Inguana.PaineisD_Acesso;

import Acessorios.JButtonModificado;
import Acessorios.PasswordText;
import Acessorios.RoundedPane;
import Acessorios.TextFieldModificado;
import Model.CargoSalario;
import Model.Funcionario;
import view_Inguana.combo_suggestion.ComboBoxSuggestion;
import view_Inguana.combo_suggestion.ComboSuggestionUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.renderer.StringValue;
import view_Inguana.scrollBar.ModernScrollBarUI;
import view_Inguana.scrollBar.ScrollBarCustom;

public class PainelFuncionario extends JPanel {

    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, lbFuncionario, lbMae; // Criação das labels
    private JPanel painel1, painel2, painel3, painelDacoplagem;
    public TextFieldModificado tfnomepf, tfIdadepf, tfBIpf, tfContactopf, tfEnderecopf, tfAnoAdmissaopf, tfCd_Cargo;
    public JButtonModificado bCadastro, bActualizar, bConsultar, bApagar, bNovo, bAtualizar, bCancelar, bPick; // Criação de variaveis de instancia da classe JButtonModificado que cria botoes customizados
    private PasswordText pw;
    public JComboBox cbSexo, cbIdade, cbCidade;
    public JTable tabela ,tabcatpf;
    RoundedPane rp;
    //ComboSuggestionUI cb;
    public ComboBoxSuggestion<String> cbsexpf;
    ScrollBarCustom sb;
    public JScrollPane sp , scrolpf;
    public JDialog dialog;

    public PainelFuncionario() {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        setBorder(null);
        // Paineis
        // --- Inicio do Tratamento dos Paineis ---
        // --- Inicio ---
        // Criando instancias dos Paineis
        painel1 = new JPanel();
        painel2 = new JPanel();
        painelDacoplagem = new JPanel();
        painel2.setLayout(new GridLayout());
        // --- Fim ---

        // Definindo o Layout dos Paineis
        // --- Inicio ---
        painel1.setLayout(null);
        painelDacoplagem.setLayout(new BorderLayout());
        // --- Fim ---

        // Definindo a Cor dos Paineis
        // --- Inicio ---
        painel1.setBackground(new Color(85, 13, 165));
        painel2.setBackground(new Color(252, 252, 252));
        painelDacoplagem.setBackground(new Color(255, 255, 255));
        // --- Fim ---

        // Definindo as dimensões do painel1
        // --- Inicio ---
        painel1.setPreferredSize(new Dimension(0, 380));
        //painel2.setPreferredSize(new Dimension(0, 330));
        // --- Fim ---
        // --- Fim do Tratamento das Label's ---
/*
        tabela = new JTable();

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

        tabela.setBackground(Color.WHITE);
        tabela.setForeground(new java.awt.Color(0, 0, 255)); // Foreground Cor azul
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(253, 224, 224));
        tabela.setBorder(null);

        JScrollPane scrollPane = new JScrollPane(tabela);

        painel2.add(scrollPane);

        painel2.add(scrollPane);
        painel1.add(painel2, BorderLayout.CENTER);
        */
        // Criando instância do ComboBoxSuggestion
        //cbsex = new ComboBoxSuggestion<>();
        cbsexpf = new ComboBoxSuggestion<>();
        cbsexpf.setUI(new ComboSuggestionUI());
        cbsexpf.setEditable(true);
        cbsexpf.setBounds(840, 200, 280, 32);
        // Adicionando alguns itens de exemplo ao ComboBox
        cbsexpf.addItem(String.valueOf("Masculino"));
        cbsexpf.addItem(String.valueOf("Feminino"));

        // Adicionando os componentes ao PainelFuncionario
        add(cbsexpf);

        // Definindo a Fonte Padrão das Label's
        // --- Inicio do Tratamento ------
        Font fonte = new Font("Segoe UI", Font.BOLD, 15);
        // --- Fim do Tratamento ---

        // Label's
        // --- Inicio do Tratamento Geral das Label's ---
        // --- Inicio ---
        // --- Criando Instâncias das Label's
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel(); // Telefone
        l5 = new JLabel();
        l6 = new JLabel();
        l7 = new JLabel("Cadastro");
        l8 = new JLabel();
        l9 = new JLabel();
        lbFuncionario = new JLabel("Funcionário");

        // --- Fim ---
        // Atribuindo a Fonte as Labels
        // --- Inicio ---
        l1.setFont(fonte);
        l2.setFont(fonte);
        l3.setFont(fonte);
        l4.setFont(fonte);
        l5.setFont(fonte);
        l6.setFont(fonte);
        l7.setFont(new Font("Segoe UI", Font.BOLD, 35));
        lbFuncionario.setFont(new Font("Segoe UI", Font.BOLD, 18));
        // --- Fim ---

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
        // --- Fim ---

        // Agrupando as JLabels & Dimensões Com as suas respectivas coordenadas
        // --- Inicío do Agrupamento ----
        l1.setBounds(20, 120, 40, 30);
        l2.setBounds(20, 160, 40, 30);
        l3.setBounds(20, 200, 40, 30);
        l8.setBounds(20, 240, 40, 30);
        l4.setBounds(1140, 120, 40, 30);
        l5.setBounds(1140, 160, 40, 30);
        l6.setBounds(1140, 200, 40, 30);
        l9.setBounds(1140, 240, 40, 30);
        l7.setBounds(20, 20, 650, 80);
        lbFuncionario.setBounds(240, 26, 650, 80);
        l1.setHorizontalAlignment(SwingConstants.LEFT);
        l2.setHorizontalAlignment(SwingConstants.LEFT);
        l3.setHorizontalAlignment(SwingConstants.LEFT);
        l4.setHorizontalAlignment(SwingConstants.LEFT);
        l5.setHorizontalAlignment(SwingConstants.LEFT);
        // --- Fim do Agrupamento ---

        // Adicionando Ícones as Label's
        // --- Inicio ---
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/nome_usuario.png")));
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/idade.png")));
        l3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bi.png")));
        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/contacto.png")));
        l5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/cidade.png")));
        l6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/sexo.png")));
        l7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/Registragem.png")));
        l8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/chave_Acesso.png")));
        l9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/ano_Admissao.png")));
        // --- Fim ---
        // --- Fim do Tratamento das Label's ---

        tfnomepf = new TextFieldModificado(ALLBITS);
        tfnomepf.setText("Nome do Funcionário");
        tfnomepf.addFocusListener(new MeuFocusListener(tfnomepf, "Nome do Funcionário"));
        tfnomepf.setBounds(70, 120, 280, 32);

        tfBIpf = new TextFieldModificado(ALLBITS);
        tfBIpf.setText("Bilhete de Identidade");
        tfBIpf.addFocusListener(new MeuFocusListener(tfBIpf, "Bilhete de Identidade"));
        tfBIpf.setBounds(70, 200, 280, 32);

        tfIdadepf = new TextFieldModificado(ALLBITS);
        tfIdadepf.setText("Idade do Funcionário");
        tfIdadepf.addFocusListener(new MeuFocusListener(tfIdadepf, "Idade do Funcionário"));
        tfIdadepf.setBounds(70, 160, 280, 32);

        tfCd_Cargo = new TextFieldModificado(ALLBITS);
        tfCd_Cargo.setText("Código de Cargo");
        tfCd_Cargo.addFocusListener(new MeuFocusListener(tfCd_Cargo, "Código de Cargo"));
        tfCd_Cargo.setBounds(70, 240, 280, 32);
        tfCd_Cargo.setEditable(false);

        tfContactopf = new TextFieldModificado(ALLBITS);
        tfContactopf.setText("Contacto do Funcionário");
        tfContactopf.addFocusListener(new MeuFocusListener(tfContactopf, "Contacto do Funcionário"));
        tfContactopf.setBounds(840, 120, 280, 32);

        tfEnderecopf = new TextFieldModificado(ALLBITS);
        tfEnderecopf.setText("Endereço do Funcionário");
        tfEnderecopf.addFocusListener(new MeuFocusListener(tfEnderecopf, "Endereço do Funcionário"));
        tfEnderecopf.setBounds(840, 160, 280, 32);

        tfAnoAdmissaopf = new TextFieldModificado(ALLBITS);
        tfAnoAdmissaopf.setText("Ano de Admissão");
        tfAnoAdmissaopf.addFocusListener(new MeuFocusListener(tfAnoAdmissaopf, "Ano de Admissão"));
        tfAnoAdmissaopf.setBounds(840, 240, 280, 32);
        
        // Botões
        // --- Inicio do Tratamento dos Botões ---
        // Agrupando as Instancias das Botões
        // --- Inicío do Agrupamento ----
        bCadastro = new JButtonModificado();
        bActualizar = new JButtonModificado();
        bConsultar = new JButtonModificado();
        bApagar = new JButtonModificado();
        bNovo = new JButtonModificado();
        bAtualizar = new JButtonModificado();
        bCancelar = new JButtonModificado();
        bPick = new JButtonModificado();
        // --- Fim de Agrupamento ---
        
        bCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bCadastro.png")));
        bActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bSave.png")));
        bConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bEdit.png")));
        bApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bDelete.png")));
        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bNew.png")));
        bAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bAtualizar.png")));
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bCancel.png")));
        bPick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bPick.png")));

        // Agrupando os Botoes
        // --- Inicío de Agrupamento ---
        bCadastro.setBackground(new Color(0, 255, 0));
        bCadastro.setForeground(Color.BLACK);
        bCadastro.setText("Cadastrar");
        bCadastro.setBounds(20, 320, 120, 30);
        // -----------------------------------------------
        bActualizar.setBackground(new Color(0, 255, 0));
        bActualizar.setForeground(Color.BLACK);
        bActualizar.setText("Actualizar");
        bActualizar.setBounds(160, 320, 120, 30);
        // -----------------------------------------------
        bConsultar.setBackground(new Color(0, 255, 0));
        bConsultar.setForeground(Color.BLACK);
        bConsultar.setText("Consultar");
        bConsultar.setBounds(300, 320, 120, 30);
        // -----------------------------------------------
        bApagar.setBackground(new Color(0, 255, 0));
        bApagar.setForeground(Color.BLACK);
        bApagar.setText("Apagar");
        bApagar.setBounds(440, 320, 120, 30);
        // -----------------------------------------------
        bNovo.setBackground(new Color(0, 255, 0));
        bNovo.setForeground(Color.BLACK);
        bNovo.setText("Novo");
        bNovo.setBounds(910, 320, 120, 30);
        // -----------------------------------------------
        bAtualizar.setBackground(new Color(0, 255, 0));
        bAtualizar.setForeground(Color.BLACK);
        bAtualizar.setText("Atualizar");
        bAtualizar.setBounds(770, 320, 120, 30);
        // -----------------------------------------------
        bCancelar.setBackground(new Color(0, 255, 0));
        bCancelar.setForeground(Color.BLACK);
        bCancelar.setText("Cancelar");
        bCancelar.setBounds(630, 320, 120, 30);
        // -----------------------------------------------
        bPick.setBackground(new Color(0, 255, 0));
        bPick.setForeground(Color.BLACK);
        bPick.setText("Pegar Cargo do Funcionario");
        bPick.setBounds(900, 320, 250, 30);
        // --- Fim de Agrupamento ---
        // --- Fim do Tratamento dos Botões ---

        painel1.add(l1);
        painel1.add(l2);
        painel1.add(l3);
        painel1.add(l4);
        painel1.add(l5);
        painel1.add(l6);
        painel1.add(l7);
        painel1.add(l8);
        painel1.add(l9);
        painel1.add(lbFuncionario);
        painel1.add(bCadastro);
        painel1.add(bActualizar);
        painel1.add(bConsultar);
        painel1.add(bApagar);
        painel1.add(bNovo);
        painel1.add(bCancelar);
        painel1.add(bAtualizar);
        painel1.add(bPick);
        
        bNovo.setVisible(false); bCancelar.setVisible(false);
        bAtualizar.setVisible(false);
           
        
        painel1.add(tfnomepf);
        painel1.add(tfBIpf);
        painel1.add(tfIdadepf);
        painel1.add(tfContactopf);
        painel1.add(tfEnderecopf);
        painel1.add(tfAnoAdmissaopf);
        painel1.add(tfCd_Cargo);
        painelDacoplagem.add(painel1, BorderLayout.NORTH);
       // painelDacoplagem.add(painel2, BorderLayout.CENTER);
        add(painelDacoplagem, BorderLayout.CENTER);
        

    }

    private class MeuFocusListener implements FocusListener {

        private TextFieldModificado textField;
        private String textoPadrao;

        public MeuFocusListener(TextFieldModificado textField, String textoPadrao) {
            this.textField = textField;
            this.textoPadrao = textoPadrao;
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (textField.getText().equals(textoPadrao)) {
                textField.setText("");
                textField.setForeground(new Color(47, 47, 47));
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (textField.getText().equals("")) {
                textField.setText(textoPadrao);
                textField.setForeground(new Color(47, 47, 47));
            }
        }
    }

    @Override
    
    
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0, 0, new Color(14, 76, 49), 0, getHeight(), new Color(89, 13, 165)));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        g2.dispose();
        super.paintComponent(g);
    }

    public void addActionListener(ActionListener action){
       bCadastro.addActionListener(action);
       bConsultar.addActionListener(action);
       bApagar.addActionListener(action);
       bActualizar.addActionListener(action);
       bPick.addActionListener(action);
   }
    public void addMouseListener (MouseListener mouse){
       tabela.addMouseListener(mouse);
   }
        public void addMouseListenerTabCatg (MouseListener mouse){
       tabcatpf.addMouseListener(mouse);
   }
 
    public Funcionario getObject(){
    
      
         String bi = tfBIpf.getText();
         String nome = tfnomepf.getText();
         int idade = Integer.parseInt(tfIdadepf.getText());
         char sexo  = (cbsexpf.getSelectedItem().toString()).charAt(0);
         System.out.println(cbsexpf.getSelectedItem().toString().charAt(0));
         String telefone =  tfContactopf.getText();
         String endereco =  tfEnderecopf.getText();
         String ano = tfAnoAdmissaopf.getText();
       
         CargoSalario cargo = null;
         
         Funcionario funcionario = new Funcionario(bi,nome,idade,sexo,telefone,endereco,ano,cargo);
    
      
   return funcionario;
     }
    
     public void popUp(JTable tabela){
        
        
        
         tabcatpf =tabela;
         tabcatpf.setDefaultEditor(Object.class, null);
         scrolpf = new JScrollPane(tabcatpf); 
        
      
         Window parentWindow = SwingUtilities.windowForComponent(this); 
        // or pass 'this' if you are inside the panel
        JFrame parentFrame = null;
        if (parentWindow instanceof JFrame) {
        parentFrame = (JFrame)parentWindow;
        }
        
        
        dialog = new JDialog(parentFrame,false);
        dialog.setSize(600,600);
        dialog.setLocationRelativeTo(null);
        dialog.add(scrolpf);
        
        dialog.setVisible(true);
         
      //  dailog.setVisible(false);
    }
     
       public void setTable(String []colunaNames, String [][]data){
         
         System.out.println("que tal");
    
        
      if(sp!=null){System.out.println("entei"); painelDacoplagem.remove(sp);
      painelDacoplagem.revalidate();}
      
     
       
        tabela= new JTable(data,colunaNames);
        tabela.setBackground(Color.WHITE);
        tabela.setForeground(new java.awt.Color(0, 0, 255)); // Foreground Cor azul
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(253, 224, 224));
        tabela.setBorder(null);
             //  System.out.println("chegui nosettav");
        
        sp = new JScrollPane(tabela);
        
              
            //        sp.setBounds(600, 80, 700, 500);
      
           
       //  painelDacoplagem.remove(painel2);
      
         
               sp.setVisible(true);
           //   painel2.setLayout(new BorderLayout());
           
          // painel2.add(sp, BorderLayout.CENTER);// painel2.revalidate();
          
            
          
            //  JPanel pal = new JPanel();  pal.add(sp);
              painelDacoplagem.add(sp, BorderLayout.CENTER);
            //  painelDacoplagem.revalidate();
              
            
             revalidate();
              
            
              
               
             
             
      
        
    
      
      
    
    }
  
    
}
