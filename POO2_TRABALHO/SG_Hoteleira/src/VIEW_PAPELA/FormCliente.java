



package VIEW_PAPELA;


import Model.CategoriaQuarto;
import Model.Cliente;
import Model.Funcionario;
import Model.Quarto;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Frederico Papela
 */
public class FormCliente  {
    
    public JButton [] butao ;
    public JLabel [] label ;
    public JTextField [] campo ;
    public  JComboBox [] combo;
    public JPanel main,tabela;
    public JTable tab;
    public JButton pick;
    public JButton pick2;
    JScrollPane sp;
    public JFrame jf,jfCategoria;
   public  JTable tableCategoria ;
   public JScrollPane scrol;
    // JTextField campoCodigo, campoPreco;
    public FormCliente(){
        
     
        main = new JPanel(null);
        combo = new JComboBox[1];
        butao = new JButton[4];
        label = new JLabel[8];
        campo = new JTextField[7];
         jfCategoria = new JFrame();
        
        String [] infoLabel = {" Bi ","Nome", "Idade","Sexo", "Telefone ","Endereco","Data do Registro","BI_Funcionario"};
        String [] infoButao = {"Inserir", "Remover","Actualizar","Consultar"};
        

        
        jf = new JFrame();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setSize(width,height);
        jf.setLocationRelativeTo(null);
        jf.setBackground(Color.WHITE);
        
        int xLabel = 270; int yLabel = 80;
        int xButao = 270; int yButao =620;
        
        for(int i=0 ; i< label.length ; i++){
            label[i] = new JLabel(infoLabel[i]);
            label[i].setLocation(40,20);
            label[i].setBounds(xLabel, yLabel, 170, 30);
            yLabel +=60;
            
            
            main.add(label[i]);  
        }
        
        for (int i =0 ; i <butao.length ; i++){
            butao[i] = new JButton(infoButao[i]);
            butao[i].setBounds(xButao,yButao,100,30);
            xButao+=140;         
            main.add(butao[i]);
        }
          int  yCampo = 80;
        for (int i =0 ; i< campo.length; i++){
            campo[i] = new JTextField (30);;
            campo[i].setBounds(xLabel+130, yCampo, 100, 30);
            if( i==6 || i==5){campo[i].setEditable(false);}
            
            main.add(campo[i]);
           if (i==2 ){yCampo +=120;}else{yCampo+=60;        
           
           }
        }
         String[] disponivel ={"M","F"};
         String [] ocupado={"M", "F"};
         String []andar ={"1","2","3","4","5","6"};
         ArrayList<String[]> tipo = new ArrayList<String[]>();
         tipo.add(disponivel); tipo.add(ocupado); tipo.add(andar);
         
         int yCombo=260;
         
        for (int i =0 ; i< 1;i++){
            combo[i]=new JComboBox(tipo.get(i));
            
            combo[i].setBounds(xLabel+130,yCombo , 100, 30);
            main.add(combo[i]);
           // yCombo +=60;
        }
        
        
        
        
        
        JLabel topLeft = new JLabel("Insira / Remova / Apague os dados do Cliente aqui !");
        JLabel topRight = new JLabel("Registros do Cliente");
        
        topLeft.setBounds(270, 30, 500, 30);
        topRight.setBounds(850, 30, 200, 30);
        main.add(topLeft); main.add(topRight);
        
        JLabel processando = new JLabel("AGUARDE!........PROCESSANDO OS DADOS do Clientes......");
        processando.setBounds(750, 300, 530, 30);
        main.add(processando);
       
        
        pick= new JButton("Pick");
        pick.setBounds(540, 500, 100, 30);
        main.add(pick);
        
        pick2 = new JButton("Pick2");
        pick2.setBounds(540,440,100,30);
        main.add(pick2);
        
        jf.add(main);
        jf.setVisible(true);
        
        
    }
    
    
    public void setTable(String []colunaNames, String [][]data){
      if(sp != null){ 
        main.remove(sp);}
       
       tab= new JTable(data,colunaNames);
               

        sp = new JScrollPane(tab);
              
                     sp.setBounds(600, 80, 700, 500);
              
             main.add(sp);
             sp.setVisible(true);
             
             
      
        
    
      
      
    }
    
    
    public void popUp(JTable tabela){
        
        /*
        String [] nomeColunas ={"Bi", "nome","idade","sexo","Telefone","endereco","ano_de_admissao","senha","email","Codigo_Cargo"};
        
          String[][] data = new String[array.size()][5];
          for (int i = 0; i < array.size(); i++) {
              data[i][0] = String.valueOf(array.get(i).getCodigo());

              data[i][1] = array.get(i).getTipo_de_cama();
              data[i][2] = String.valueOf(array.get(i).getPreco_normal());
              data[i][3] = String.valueOf(array.get(i).getPreco_reserva());
              data[i][4] = array.get(i).getTipoQuarto();}
              data[i][5]= null;*/
         tableCategoria =tabela;
         tableCategoria.setDefaultEditor(Object.class, null);
         scrol = new JScrollPane(tableCategoria); 

        //table.addMouseListener(trata);
         
        
        jfCategoria.setSize(700,700);
        jfCategoria.setLocationRelativeTo(null);
        jfCategoria.add(scrol);
        jfCategoria.setVisible(true);
    }
    
    
    
    
    
    public int inter(String string){
        return Integer.parseInt(string);
    }
    
     public Cliente getObject(){
    
       String bi =campo[0].getText();
       String nome =  campo[1].getText();
       int idade =  Integer.parseInt(campo[2].getText());
       char sexo = combo[0].getSelectedItem().toString().charAt(0);
       String telefone = campo[3].getText();
       String endereco = campo[4].getText();
       
       Date dataRegistro = new Date((campo[5].getText()));
       
       int Bi_atendente = Integer.parseInt(campo[6].getText());
   
       Cliente cliente = new Cliente(bi,nome,idade,sexo,telefone,endereco,dataRegistro,Bi_atendente);
   
       return cliente;
     }
    
    
    public CategoriaQuarto getObjectWithID(){
       return null;
        
    }
    
    public void consultaCategoria(){
  
        JPanel pa = new JPanel();
        jfCategoria.add(pa); jfCategoria.setVisible(true);
        
    }


   public void addActionListener(ActionListener action){
        pick.addActionListener(action);
        pick2.addActionListener(action);
       for(int i =0; i<butao.length;i++){
           butao[i].addActionListener(action);
           
        
       }
       
          
       
       
   }
   
   public void addMouseListener (MouseListener mouse){
         
         tableCategoria.addMouseListener(mouse);
   }
   public void addMouseListenerTab (MouseListener mouse){
       tab.addMouseListener(mouse);
   }
    
    public static void main(String[] args) {
        new FormCliente();
    }
        
}
