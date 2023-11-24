package view_Inguana.PaineisD_Acesso;

import Acessorios.JButtonModificado;
import Acessorios.PasswordText;
import Acessorios.RoundedPane;
import Acessorios.TextFieldModificado;
import Model.CategoriaQuarto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import static java.awt.image.ImageObserver.ALLBITS;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import view_Inguana.combo_suggestion.ComboBoxSuggestion;
import view_Inguana.combo_suggestion.ComboSuggestionUI;
import view_Inguana.scrollBar.ScrollBarCustom;

public class PainelRQuarto extends JPanel {

    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, lbFuncionario, lbMae; // Criação das labels
    private JPanel painel1, painel2, painel3, painelDacoplagem;
    public TextFieldModificado tfCodigo, tfPreco, tfContacto, tfCd_Categoria,tfPrecoReserva;
    public JButtonModificado bCadastro, bActualizar, bConsultar, bApagar, bNovo, bAtualizar, bCancelar, bPick; // Criação de variaveis de instancia da classe JButtonModificado que cria botoes customizados
    private PasswordText pw;
    public JTable tabela, tabCat;
    RoundedPane rp;
    //ComboSuggestionUI cb;
    public ComboBoxSuggestion<String> cbCama, cbQuarto;
    ScrollBarCustom sb;
    JScrollPane sp;
   

    public PainelRQuarto() {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
       // setBorder(null);
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
        */
       // painel1.add(painel2, BorderLayout.CENTER);

        // Criando instância do ComboBoxSuggestion
        //cb = new ComboBoxSuggestion<>();
        cbCama = new ComboBoxSuggestion<String>();
        cbCama.setUI(new ComboSuggestionUI());
        cbCama.setEditable(true);
        cbCama.setBounds(840, 160, 280, 32);
        // Adicionando alguns itens de exemplo ao ComboBox
        cbCama.addItem("Tipo de Cama");
        cbCama.addItem("Solteiro");
        cbCama.addItem("King");
        cbCama.addItem("Casal");
        cbCama.addItem("Beliche");
        
        

        // Adicionando os componentes ao PainelFuncionario
        painel1.add(cbCama);
        // Criando instância do ComboBoxSuggestion
        //cb = new ComboBoxSuggestion<>();
        cbQuarto = new ComboBoxSuggestion<>();
        cbQuarto.setUI(new ComboSuggestionUI());
        cbQuarto.setEditable(true);
        cbQuarto.setBounds(70, 160, 280, 32);
        // Adicionando alguns itens de exemplo ao ComboBox
        cbQuarto.addItem("Normal");
        cbQuarto.addItem("VIP");

        // Adicionando os componentes ao PainelFuncionario
        painel1.add(cbQuarto);

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
        lbFuncionario = new JLabel("Categoria do Quarto");

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
        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/chave_Acesso.png")));
        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/vip.png")));
        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/price.png")));
        l5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/cama_Hotel.png")));
        l7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_Inguana/Icons/Registragem.png")));
        // --- Fim ---
        // --- Fim do Tratamento das Label's ---

        tfCodigo = new TextFieldModificado(ALLBITS);
        tfCodigo.setText("Código de Acesso");
        tfCodigo.addFocusListener(new PainelRQuarto.MeuFocusListener(tfCodigo, "Código"));
        tfCodigo.setBounds(70, 120, 280, 32);
        tfCodigo.setEditable(false);

        tfPreco = new TextFieldModificado(ALLBITS);
        tfPreco.setText("Preço Normal do Quarto");
        tfPreco.addFocusListener(new PainelRQuarto.MeuFocusListener(tfPreco, "Preço Normal do Quarto"));
        tfPreco.setBounds(840, 120, 280, 32);
        tfPreco.setEditable(true);
        
         tfPrecoReserva = new TextFieldModificado(ALLBITS);
       tfPrecoReserva.setText("Preço VIP do Quarto");
        tfPrecoReserva.addFocusListener(new PainelRQuarto.MeuFocusListener(tfPrecoReserva, "Preço VIP do Quarto"));
        tfPrecoReserva.setBounds(840, 200, 280, 32);
       tfPrecoReserva.setEditable(true);

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
        bPick.setText("Pick");
        bPick.setBounds(1050, 320, 120, 30);
        // --- Fim de Agrupamento ---
        // --- Fim do Tratamento dos Botões ---

        painel1.add(l1);
        painel1.add(l2);
        painel1.add(l4);
        painel1.add(l5);
        painel1.add(l7);
        painel1.add(lbFuncionario);

        painel1.add(bCadastro);
        painel1.add(bActualizar);
        painel1.add(bConsultar);
        painel1.add(bApagar);
        painel1.add(bNovo);
        painel1.add(bCancelar);
        painel1.add(bAtualizar);
        painel1.add(bPick);
        bNovo.setVisible(false); bCancelar.setVisible(false); bAtualizar.setVisible(false); bPick.setVisible(false);
        painel1.add(tfCodigo);
        painel1.add(tfPreco);
        painel1.add(tfPrecoReserva);

        painelDacoplagem.add(painel1, BorderLayout.NORTH);
       
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


public void addActionListener(ActionListener action){
       bCadastro.addActionListener(action);
       bConsultar.addActionListener(action);
       bApagar.addActionListener(action);
       bActualizar.addActionListener(action);
   }
 public CategoriaQuarto getObject(){
       // String 
      /* Object Empty =null;
       if(!combo[0].getSelectedItem().equals(Empty)){
           
           JOptionPane.showMessageDialog(null,  "Ja foi cadastrado");
        return null;
       }else{*/
       
       String tipoCama = (cbCama.getSelectedItem()).toString();
       
       String tipoQuarto=(cbQuarto.getSelectedItem()).toString();
       int precoNormal = Integer.parseInt(tfPreco.getText());
       int precoReserva = Integer.parseInt(tfPrecoReserva.getText());
       /* System.out.println(tipoCama);
        System.out.println(tipoQuarto);
        System.out.println(precoNormal);
        System.out.println(precoReserva);*/
       CategoriaQuarto cate = new CategoriaQuarto(tipoCama,precoNormal,precoReserva,tipoQuarto);
       return cate;
       
     //} 
    }
 
 public void addMouseListener (MouseListener mouse){
       tabela.addMouseListener(mouse);
   }
 
  
    
 
 public CategoriaQuarto getObjectWithID(){
     CategoriaQuarto cat =getObject();
     cat.setCodigo(Integer.parseInt(tfCodigo.getText()));
     return cat;
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
               
        
        sp = new JScrollPane(tabela);
              
                    sp.setBounds(600, 80, 700, 500);
              sp.setVisible(true);
             
            // painel2.add(sp);
              painelDacoplagem.add(sp, BorderLayout.CENTER);
              
              revalidate();
             
             
      
        
    
      
      
    }
   
}
