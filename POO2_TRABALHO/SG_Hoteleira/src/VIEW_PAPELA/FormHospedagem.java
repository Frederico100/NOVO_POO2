package VIEW_PAPELA;


import Model.CategoriaQuarto;
import Model.Cliente;
import Model.Funcionario;
import Model.Hospedagem;
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
import javax.swing.JDialog;
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
public class FormHospedagem  {
    
    public JButton [] butao ;
    public JLabel [] label ;
    public JTextField [] campo ;
    public  JComboBox [] combo;
    public JPanel main,tabela;
    public JTable tab;
    public JButton pick;
    public JButton pick2,calculate;
    JScrollPane sp;
    public JFrame jf;
   public  JTable tableCategoria ;
   public JScrollPane scrol;
   JFrame jfCategoria;
   public JDialog dailog;
    // JTextField campoCodigo, campoPreco;
    public FormHospedagem(){
        
        
       
        main = new JPanel(null);
       // combo = new JComboBox[1];
        butao = new JButton[4];
        label = new JLabel[6];
        campo = new JTextField[6];
        jfCategoria = new JFrame();
        
        
        String [] infoLabel = {" id "," dataInicio", "dataFim","valor_apagar", " numero_quarto","bi_cliente"};
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
            if(i!=2 && i!=3){campo[i].setEditable(false);}
            
            main.add(campo[i]);
            yCampo+=60;
          /* if (i==2 ){yCampo +=120;}else{yCampo+=60;        
           
           }*/
        }
        
        /*
        String[] disponivel ={"M","F"};
         String [] ocupado={"M", "F"};
         String []andar ={"1","2","3","4","5","6"};
         ArrayList<String[]> tipo = new ArrayList<String[]>();
         tipo.add(disponivel); tipo.add(ocupado); tipo.add(andar);
         /*
         int yCombo=260;
         
        for (int i =0 ; i< 1;i++){
            combo[i]=new JComboBox(tipo.get(i));
            
            combo[i].setBounds(xLabel+130,yCombo , 100, 30);
            main.add(combo[i]);
           // yCombo +=60;
        }
        */
        
        
        
        
        JLabel topLeft = new JLabel("Insira / Remova / Apague os dados do Hospedagem aqui !");
        JLabel topRight = new JLabel("Registros de Hospedagem");
        
        topLeft.setBounds(270, 30, 500, 30);
        topRight.setBounds(850, 30, 200, 30);
        main.add(topLeft); main.add(topRight);
        
        JLabel processando = new JLabel("AGUARDE!........PROCESSANDO OS DADOS da Hospedagem......");
        processando.setBounds(750, 300, 530, 30);
        main.add(processando);
       
        
        pick= new JButton("Pick");
        pick.setBounds(540, 380, 100, 30);
        main.add(pick);
        
        pick2 = new JButton("Pick2");
        pick2.setBounds(540,320,100,30);
        main.add(pick2);
        
        calculate = new JButton ("Calcular");
        calculate.setBounds(540, 250, 100, 30);
        main.add(calculate);
        jf.add(main);
        
        jf.setVisible(true);
       
        //jfCategoria.setVisible(false);
      
        
        
    }
    
    
    public void setTable(String []colunaNames, String [][]data){
      if(sp != null){ 
        main.remove(sp);}
       
       tab= new JTable(data,colunaNames);
               

        sp = new JScrollPane(tab);
              
                     sp.setBounds(600, 80, 700, 500);
              sp.setVisible(true);
             main.add(sp);
             
             
             
      
        
    
      
      
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
         
         
       
         
        jfCategoria.setSize(700,700);
       // jfCategoria.setLocationRelativeTo(jf);
        jfCategoria.add(scrol);
       // jfCategoria.setVisible(true);
       // jfCategoria.setLocationRelativeTo(null);
      //  jfCategoria.setVisible(true);
         dailog = new JDialog(jf,false);
        dailog.setSize(600,600);
        dailog.setLocationRelativeTo(null);
        dailog.add(scrol);
        dailog.setVisible(true);
      //  dailog.setVisible(false);
    }
    
    
    
    
    
    public int inter(String string){
        return Integer.parseInt(string);
    }
    /*
    public Hospedagem getObject(){
    
       
//       int id =  Integer.parseInt(campo[0].getText());
       int numero_quarto =  Integer.parseInt(campo[4].getText());
       String bi_cliente =  campo[5].getText();
       float valorApagar = Float.parseFloat(campo[3].getText());
     
         
       Date dataInicio = new Date();
       Date dataFim = new Date(campo[2].getText());
    //   Hospedagem hospedagem = new Hospedagem(0, valorApagar,dataInicio,dataFim,numero_quarto, bi_cliente);
         return hospedagem;
     }
    */
    /*
    
    public Hospedagem getObjectWithID(){
       Hospedagem hospedagem =getObject();
         int id =  Integer.parseInt(campo[0].getText());
         hospedagem.setId(id);
         return hospedagem;
        
    }*/
    
    /*public void consultaCategoria(){
  
        JPanel pa = new JPanel();
        jfCategoria.add(pa); jfCategoria.setVisible(true);
        
    }*/


   public void addActionListener(ActionListener action){
        pick.addActionListener(action);
        pick2.addActionListener(action);
        calculate.addActionListener(action);
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
        new FormHospedagem();
    }
        
}
