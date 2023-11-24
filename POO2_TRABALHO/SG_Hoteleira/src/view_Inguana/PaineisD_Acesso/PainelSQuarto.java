package view_Inguana.PaineisD_Acesso;

import Acessorios.JButtonModificado;
import Acessorios.PasswordText;
import Acessorios.RoundedPane;
import Acessorios.TextFieldModificado;
import Model.CategoriaQuarto;
import Model.Quarto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import static java.awt.image.ImageObserver.ALLBITS;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import view_Inguana.Acessorios.RoundedJFormattedTextField;
import view_Inguana.combo_suggestion.ComboBoxSuggestion;
import view_Inguana.combo_suggestion.ComboSuggestionUI;
import view_Inguana.scrollBar.ScrollBarCustom;

public class PainelSQuarto extends JPanel {

    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, lbFuncionario, lbMae; // Criação das labels
    private JPanel painel1, painel2, painel3, painelDacoplagem;
    //private TextFieldModificado ;
    public JButtonModificado bCadastro, bActualizar, bConsultar, bApagar, bgetcat, bAtualizar, bCancelar, bPick; // Criação de variaveis de instancia da classe JButtonModificado que cria botoes customizados
    private PasswordText pw;
    private JComboBox cbSexo, cbIdade, cbCidade;
    public JTable tabela, tabcat;
    RoundedPane rp;
    //ComboSuggestionUI cb;
    public ComboBoxSuggestion<String> cbDisponibilidade, cbOcupacao;
    public RoundedJFormattedTextField tfContacto, tfAndar, tfCodigo, tfCd_Categoria;  // Substituir o tipo do TextField para RoundedJFormattedTextField
  
    ScrollBarCustom sb;
     public JScrollPane sp,scrol;
    public JFrame jfcateg;
   public   JDialog dailog;
    

    public PainelSQuarto() {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
//        setBorder(null);
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
        //cb = new ComboBoxSuggestion<>();
         cbDisponibilidade = new ComboBoxSuggestion<>();
        cbDisponibilidade.setUI(new ComboSuggestionUI());
        cbDisponibilidade.setEditable(true);
        cbDisponibilidade.setBounds(840, 160, 280, 32);
        // Adicionando alguns itens de exemplo ao ComboBox
        cbDisponibilidade.addItem("Disponivel");
        cbDisponibilidade.addItem("Indisponivel");

        // Adicionando os componentes ao PainelFuncionario
        painel1.add(cbDisponibilidade);
        // Criando instância do ComboBoxSuggestion
        //cb = new ComboBoxSuggestion<>();
        cbOcupacao = new ComboBoxSuggestion<>();
        cbOcupacao.setUI(new ComboSuggestionUI());
        cbOcupacao.setEditable(true);
        cbOcupacao.setBounds(70, 160, 280, 32);
        // Adicionando alguns itens de exemplo ao ComboBox
        cbOcupacao.addItem("Ocupado");
        cbOcupacao.addItem("Desocupado");

        // Adicionando os componentes ao PainelFuncionario
        painel1.add(cbOcupacao);

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
        lbFuncionario = new JLabel("Quarto");

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
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/door_Code.png")));
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/disponibilidade.png")));
        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/codigo_Categoria.png")));
        l5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/ocupado.png")));
        l6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/contacto.png")));
        l3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/andar.png")));
        l7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/Registragem.png")));
        // --- Fim ---
        // --- Fim do Tratamento das Label's ---

        tfCodigo = new RoundedJFormattedTextField(createFormatter("(NºQuarto) ###"));
        tfCodigo.setText("Número de Quarto 3digito");
        tfCodigo.addFocusListener(new MeuFormattedTextFieldFocusListener(tfCodigo, "Número de Quarto 3digito"));
        tfCodigo.setBounds(70, 120, 280, 32);
        tfCodigo.setEditable(false);

        tfAndar = new RoundedJFormattedTextField(createFormatter("(Piso) ##"));
        tfAndar.setText("Andar do Prédio");
        tfAndar.addFocusListener(new MeuFormattedTextFieldFocusListener(tfAndar, "Andar do Prédio"));
        tfAndar.setBounds(70, 200, 280, 32);
        tfAndar.setEditable(true);

        tfCd_Categoria = new RoundedJFormattedTextField(createFormatter("(Cd Categoria) ####"));
        tfCd_Categoria.setText("Código da Categoria");
       tfCd_Categoria.addFocusListener(new MeuFormattedTextFieldFocusListener(tfCd_Categoria, "Código da Categoria"));
        tfCd_Categoria.setBounds(840, 120, 280, 32);
        tfCd_Categoria.setEditable(false);

        tfContacto = new RoundedJFormattedTextField(createFormatter("(+258) #########"));
        tfContacto.setText("Contacto do Hospede");
        tfContacto.addFocusListener(new MeuFormattedTextFieldFocusListener(tfContacto, "Contacto do Hospede"));
        tfContacto.setBounds(840, 200, 280, 32);
        tfContacto.setEditable(true);

        bCadastro = new JButtonModificado();
        bActualizar = new JButtonModificado();
        bConsultar = new JButtonModificado();
        bApagar = new JButtonModificado();
        bgetcat = new JButtonModificado();
        bAtualizar = new JButtonModificado();
        bCancelar = new JButtonModificado();
        bPick = new JButtonModificado();
        // --- Fim de Agrupamento ---
        
        bCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bCadastro.png")));
        bActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bSave.png")));
        bConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bEdit.png")));
        bApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bDelete.png")));
        bgetcat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/bNew.png")));
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
        bgetcat.setBackground(new Color(0, 255, 0));
        bgetcat.setForeground(Color.BLACK);
        bgetcat.setText("Pegar categoria do Quarto");
        bgetcat.setBounds(910, 320, 240, 30);
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
        bPick.setText("Pick");
        bPick.setBounds(1050, 320, 120, 30);
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
        painel1.add(bgetcat);
        painel1.add(bCancelar);
        painel1.add(bAtualizar);
        painel1.add(bPick);
        bCancelar.setVisible(false); bAtualizar.setVisible(false);
        bPick.setVisible(false);
        painel1.add(tfCodigo);
        painel1.add(tfAndar);
        painel1.add(tfCd_Categoria);
        painel1.add(tfContacto);
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
      public void popUp(JTable tabela){
        
        
        
         tabcat =tabela;
         tabcat.setDefaultEditor(Object.class, null);
         scrol = new JScrollPane(tabcat); 
        
      
         Window parentWindow = SwingUtilities.windowForComponent(this); 
        // or pass 'this' if you are inside the panel
        Frame parentFrame = null;
        if (parentWindow instanceof Frame) {
        parentFrame = (Frame)parentWindow;
}

         dailog = new JDialog(parentFrame,false);
        dailog.setSize(600,600);
        dailog.setLocationRelativeTo(null);
        dailog.add(scrol);
        dailog.setVisible(true);
      //  dailog.setVisible(false);
    }
    

    public void addActionListener(ActionListener action){
        
       bCadastro.addActionListener(action);
       bConsultar.addActionListener(action);
       bApagar.addActionListener(action);
       bActualizar.addActionListener(action);
       bgetcat.addActionListener(action);
   }
    public void addMouseListener (MouseListener mouse){
      
       tabcat.addMouseListener(mouse);
   }
    public void addMouseListenerTab (MouseListener mouse){
      
       tabela.addMouseListener(mouse);
   }
    
  public void setTable(String []colunaNames, String [][]data){
      if(sp != null){ sp.setVisible(false);
        painel2.remove(sp);}
       
        tabela= new JTable(data,colunaNames);
        tabela.setBackground(Color.WHITE);
        tabela.setForeground(new java.awt.Color(0, 0, 255)); // Foreground Cor azul
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setSelectionBackground(new java.awt.Color(253, 224, 224));
        tabela.setBorder(null);
               System.out.println("chegui nosettav");
        
        sp = new JScrollPane(tabela);
              
            //        sp.setBounds(600, 80, 700, 500);
              sp.setVisible(true);
             
            // painel2.add(sp);
              painelDacoplagem.add(sp, BorderLayout.CENTER);
              
              revalidate();
             
             
      
        
    
      
      
    }
  
   public Quarto getObject(){
    
      
       String telefone =  getPalavra(tfContacto.getText());
       System.out.println("te" + telefone);
       System.out.println("imprimindo"+ getPalavra(tfAndar.getText()));
       int andar =  Integer.parseInt(getPalavra(tfAndar.getText()));
      String disponivel = cbDisponibilidade.getSelectedItem().toString();
      String ocupado = cbOcupacao.getSelectedItem().toString();
      
       System.out.println("disponibilidade.."+ disponivel);
       System.out.println("ocupado" + ocupado);
           
     
   
      CategoriaQuarto categoria =null;
      
       Quarto quarto = new Quarto (telefone,ocupado,disponivel,andar,categoria);
       System.out.println("teste proble" + getPalavra(tfCodigo.getText()));
         if(!getPalavra(tfCodigo.getText()).isEmpty()){
         int codigo =Integer.parseInt(getPalavra(tfCodigo.getText()));
          quarto.setNumero(codigo);
      }
            return quarto;
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

}
