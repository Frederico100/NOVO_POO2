package view_Inguana.PaineisD_Acesso;

import Acessorios.JButtonModificado;
import Acessorios.PasswordText;
import Acessorios.RoundedPane;
import Acessorios.TextFieldModificado;
import Model.CargoSalario;
import Model.Cliente;
import Model.Funcionario;
import Model.Hospedagem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import static java.awt.image.ImageObserver.ALLBITS;
import java.util.Date;
import javax.annotation.processing.RoundEnvironment;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
import view_Inguana.Acessorios.RoundedJFormattedTextField;
import view_Inguana.combo_suggestion.ComboBoxSuggestion;
import view_Inguana.combo_suggestion.ComboSuggestionUI;
import view_Inguana.scrollBar.ScrollBarCustom;

public class PaineslSHospedagem extends JPanel {

    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, lbFuncionario, lbMae; // Criação das labels
    private JPanel painel1, painel2, painel3, painelDacoplagem;
    //private TextFieldModificado tfnome, tfIdade, tfBI, tfContacto, tfEndereco, tfAnoAdmissao, tfCd_Cargo;
    public JButtonModificado bCadastro, bActualizar, bConsultar, bApagar, bPickqua, bcalc, bCancelar, bPickcli; // Criação de variaveis de instancia da classe JButtonModificado que cria botoes customizados
    private PasswordText pw;
    private JComboBox cbSexo, cbIdade, cbCidade;
    public JTable tabela,tabcat;
    RoundedPane rp;
    //ComboSuggestionUI cb;
    public ComboBoxSuggestion<String> cb;
    public RoundedJFormattedTextField tfDataInicio, tfDataFim, tfValorApagar, tfNQuarto, tfidho;
    ScrollBarCustom sb;
    public JScrollPane sp,scrol;
    public JDialog dailog;
    public TextFieldModificado  tfBI_Cliente;

    public PaineslSHospedagem() {
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
        l7 = new JLabel("Serviços");
        l8 = new JLabel();
        l9 = new JLabel();
        lbFuncionario = new JLabel("Hospedagem");

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
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/data_Inicio.png")));
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/data_Fim.png")));
        l3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/pagamento.png")));
        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bi.png")));
        l5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/id.png")));
        l6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/door_Code.png")));
        l7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/logo_Servico.png")));
        // --- Fim ---
        // --- Fim do Tratamento das Label's ---

        tfDataInicio = new RoundedJFormattedTextField(createFormatter("(Início_de_hospedagem) ####/##/##"));
        tfDataInicio.setText("Nome do Funcionário");
        tfDataInicio.addFocusListener(new MeuFormattedTextFieldFocusListener(tfDataInicio, "Nome do Funcionário"));
        tfDataInicio.setBounds(70, 120, 280, 32);

        tfDataFim = new RoundedJFormattedTextField(createFormatter("(Fim_de_hospedagem) ####/##/##"));
        tfDataFim.setText("Bilhete de Identidade");
        tfDataFim.addFocusListener(new MeuFormattedTextFieldFocusListener(tfDataFim, "Bilhete de Identidade"));
        tfDataFim.setBounds(70, 160, 280, 32);
        
        tfValorApagar = new RoundedJFormattedTextField(createFormatter("(Valor_a_Pagar_5_digitos) ####.# Mt"));
        tfValorApagar.setText("Idade do Funcionário");
        tfValorApagar.addFocusListener(new MeuFormattedTextFieldFocusListener(tfValorApagar, "Idade do Funcionário"));
        tfValorApagar.setBounds(70, 200, 280, 32);

        tfNQuarto = new RoundedJFormattedTextField(createFormatter("(Nº_do_Quarto) ##"));
        tfNQuarto.setText("Código de Cargo");
        tfNQuarto.addFocusListener(new MeuFormattedTextFieldFocusListener(tfNQuarto, "Código de Cargo"));
        tfNQuarto.setBounds(840, 200, 280, 32);

        tfBI_Cliente = new TextFieldModificado(ALLBITS);
        tfBI_Cliente.setText("Bilhete de Identidade do Hópede");
        tfBI_Cliente.addFocusListener(new PaineslSHospedagem.MeuFocusListener(tfBI_Cliente, "Bilhete de Identidade do Hópede"));
        tfBI_Cliente.setBounds(840, 120, 280, 32);
        /*
        tfBI_Cliente = new RoundedJFormattedTextField(createFormatter("(BI)  "));
        tfBI_Cliente.setText("Contacto do Funcionário");
        tfBI_Cliente.addFocusListener(new MeuFormattedTextFieldFocusListener(tfBI_Cliente, "Contacto do Funcionário"));
        tfBI_Cliente.setBounds(840, 120, 280, 32);
*/
        tfidho = new RoundedJFormattedTextField(createFormatter("(ID) ##"));
        tfidho.setText("Contacto do Funcionário");
        tfidho.addFocusListener(new MeuFormattedTextFieldFocusListener(tfidho, "Contacto do Funcionário"));
        tfidho.setBounds(840, 160, 280, 32);

        // Botões
        // --- Inicio do Tratamento dos Botões ---
        // Agrupando as Instancias das Botões
        // --- Inicío do Agrupamento ----
        bCadastro = new JButtonModificado();
        bActualizar = new JButtonModificado();
        bConsultar = new JButtonModificado();
        bApagar = new JButtonModificado();
        bPickqua = new JButtonModificado();
        bcalc = new JButtonModificado();
        bCancelar = new JButtonModificado();
        bPickcli = new JButtonModificado();
        // --- Fim de Agrupamento ---

        bCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bCadastro.png")));
        bActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bSave.png")));
        bConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bEdit.png")));
        bApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bDelete.png")));
        bPickqua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bNew.png")));
        bcalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bAtualizar.png")));
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bCancel.png")));
        bPickcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bPick.png")));

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
        bPickqua.setBackground(new Color(0, 255, 0));
        bPickqua.setForeground(Color.BLACK);
        bPickqua.setText("Pegar numero de quarto");
        bPickqua.setBounds(600, 320, 200, 30);
        // -----------------------------------------------
        bcalc.setBackground(new Color(0, 255, 0));
        bcalc.setForeground(Color.BLACK);
        bcalc.setText("Calcular valor a pagar");
        bcalc.setBounds(820, 320, 160, 30);
        // -----------------------------------------------
        bCancelar.setBackground(new Color(0, 255, 0));
        bCancelar.setForeground(Color.BLACK);
        bCancelar.setText("Cancelar");
        bCancelar.setBounds(630, 320, 120, 30);
        // -----------------------------------------------
        bPickcli.setBackground(new Color(0, 255, 0));
        bPickcli.setForeground(Color.BLACK);
        bPickcli.setText("Pegar bi do cliente ");
        bPickcli.setBounds(990, 320, 150, 30);
        // --- Fim de Agrupamento ---
        // --- Fim do Tratamento dos Botões ---

        painel1.add(l1);
        painel1.add(l2);
        painel1.add(l3);
        painel1.add(l4);
        painel1.add(l5);
        painel1.add(l6);
        painel1.add(l7);
        painel1.add(lbFuncionario);
        painel1.add(bCadastro);
        painel1.add(bActualizar);
        painel1.add(bConsultar);
        painel1.add(bApagar);
        painel1.add(bPickqua);
        painel1.add(bCancelar);
        painel1.add(bcalc);
        painel1.add(bPickcli);
        
      
        bCancelar.setVisible(false);
        
        painel1.add(tfDataInicio);
        painel1.add(tfDataFim);
        painel1.add(tfValorApagar);
        painel1.add(tfNQuarto);
        painel1.add(tfBI_Cliente);
        painel1.add(tfidho);
        painelDacoplagem.add(painel1, BorderLayout.NORTH);
      //  painelDacoplagem.add(painel2, BorderLayout.CENTER);
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

    private MaskFormatter createFormatter(String pattern) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(pattern);
        } catch (java.text.ParseException ex) {
            System.err.println("Formatter is bad: " + ex.getMessage());
        }
        return formatter;
    }

    private class MeuFormattedTextFieldFocusListener implements FocusListener {

        private RoundedJFormattedTextField formattedTextField;
        private String textoPadrao;

        public MeuFormattedTextFieldFocusListener(RoundedJFormattedTextField formattedTextField, String textoPadrao) {
            this.formattedTextField = formattedTextField;
            this.textoPadrao = textoPadrao;
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (formattedTextField.getText().equals(textoPadrao)) {
                formattedTextField.setText("");
                formattedTextField.setForeground(new Color(47, 47, 47));
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (formattedTextField.getText().equals("")) {
                formattedTextField.setText(textoPadrao);
                formattedTextField.setForeground(new Color(47, 47, 47));
            }
        }
    }
    public void addActionListener(ActionListener action){
       
       bCadastro.addActionListener(action);
       bConsultar.addActionListener(action);
       bApagar.addActionListener(action);
       bActualizar.addActionListener(action);
       bcalc.addActionListener(action);
       bPickcli.addActionListener(action);
       bPickqua.addActionListener(action);
       
           
        
       }

    
    public void addMouseListener (MouseListener mouse){
         
         tabela.addMouseListener(mouse);
   }
   public void addMouseListenerTabCat (MouseListener mouse){
       tabcat.addMouseListener(mouse);
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
   
   public Hospedagem getObject(){
       
       
       
       Date dInicio= new Date(( tfDataInicio.getText()));
       
       Date dFim =new Date((tfDataFim.getText()));
       System.out.println(getPalavra(tfValorApagar.getText()));
    
       float val = Float.parseFloat(getPalavra(tfValorApagar.getText()));
       
       String biClie = getPalavra(tfBI_Cliente.getText());
       
       String idHospe = getPalavra(tfidho.getText());
       
       int quarto = Integer.parseInt(getPalavra(tfNQuarto.getText()));
       
       
       
       
       
    /*
       String bi =tfBI.getText();
       String nome =  tfnome.getText();
       int idade =  Integer.parseInt(tfIdade.getText());
       char sexo = cbsex.getSelectedItem().toString().charAt(0);
       String telefone = getPalavra(tfContacto.getText());
       String endereco = tfEndereco.getText();
       
       Date dataRegistro = new Date((tfDateRegistro.getText()));
       
       int Bi_atendente = Integer.parseInt(getPalavra(tfCdfuncio.getText()));
   */
       //Cliente cliente = new Cliente(bi,nome,idade,sexo,endereco,telefone,dataRegistro,Bi_atendente);
   
       Hospedagem hos = new Hospedagem(val,dInicio,dFim,quarto,biClie);
       return hos;
     }
   
     public Hospedagem getObjectWithID(){
        Hospedagem hospedagem = getObject();
        hospedagem.setId(Integer.parseInt(getPalavra(tfidho.getText())));
        return hospedagem;
    }
   
      public  int search (String str){
        int index=-1;
        for (int i =0 ; i< str.length(); i++){
          if((str.charAt(i))==' '){index=i; break;}
          
        }
        return index;
    
    }
       
    public  String getPalavra(String strs){
     String palavra = "";
        
     int ind = search(strs)+1;
     for(int i =ind; i<strs.length();i++){
         if(strs.charAt(i)==' '){break;}
         palavra +=strs.charAt(i);
              }
 
      return palavra;
}
   public void popUp(JTable tabela){
        
        
        
         tabcat =tabela;
         tabcat.setDefaultEditor(Object.class, null);
         scrol = new JScrollPane(tabcat); 
        
      
         Window parentWindow = SwingUtilities.windowForComponent(this); 
        // or pass 'this' if you are inside the panel
        JFrame parentFrame = null;
        if (parentWindow instanceof JFrame) {
        parentFrame = (JFrame)parentWindow;
        }
        
        
        dailog = new JDialog(parentFrame,false);
        dailog.setSize(600,600);
        dailog.setLocationRelativeTo(null);
        dailog.add(scrol);
        
        dailog.setVisible(true);
         
      //  dailog.setVisible(false);
    }
     
}
