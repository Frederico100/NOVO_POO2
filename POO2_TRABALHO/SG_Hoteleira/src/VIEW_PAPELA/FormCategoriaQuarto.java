
package VIEW_PAPELA;

import Controller.CategoriaQuartoController;
import Model.CategoriaQuarto;
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
import java.util.ArrayList;
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
public class FormCategoriaQuarto  {
    CategoriaQuartoController controllerCategoriaQuarto;
    public JButton [] butao ;
    public JLabel [] label ;
    public JTextField [] campo ;
    public  JComboBox [] combo;
    public JPanel main,tabela;
    public JTable tab;
    public JScrollPane sp;
    public JFrame jf;
    // JTextField campoCodigo, campoPreco;
    public FormCategoriaQuarto(){
        
     
        main = new JPanel(null);
        combo = new JComboBox[2];
        butao = new JButton[4];
        label = new JLabel[5];
        campo = new JTextField[3];
        String [] infoLabel = {"Codigo","Tipo de Cama", "Preco Normal","Preco Reserva", "Tipo de Quarto "};
        String [] infoButao = {"Inserir", "Remover","Actualizar","Consultar"};
        
        /*
        
         private int codigo;
    private String tipo_de_cama;
    private int preco_normal;
    private int preco_reserva;
    private String tipoQuarto;
        
        
        */
        
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
            label[i].setBounds(xLabel, yLabel, 100, 30);
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
            if(i==0){campo[i].setEditable(false);}
            
            main.add(campo[i]);
           if(i==0){ yCampo+=120;} if(i==1){yCampo+=60;}
        }
         String[] tipoCama ={"Solteiro","Casal"};
         String [] tipoQuarto={"Normal", "Vip"};
         ArrayList<String[]> tipo = new ArrayList<String[]>();
         tipo.add(tipoCama); tipo.add(tipoQuarto);
         int yCombo=0;
         
        for (int i =0 ; i< 2;i++){
            combo[i]=new JComboBox(tipo.get(i));
            if(i==0){yCombo =140;} if(i==1){yCombo = 320;}
            combo[i].setBounds(xLabel+130,yCombo , 100, 30);
            main.add(combo[i]);
        }
        
        
        
        //tags
        
        JLabel topLeft = new JLabel("Insira / Remova / Apague os dados de Categoria Quarto aqui !");
        JLabel topRight = new JLabel("Registros da Categoria Quarto");
        
        topLeft.setBounds(270, 30, 500, 30);
        topRight.setBounds(850, 30, 200, 30);
        main.add(topLeft); main.add(topRight);
        
        JLabel processando = new JLabel("AGUARDE!........PROCESSANDO OS DADOS DA CATEGORIA QUARTO......");
        processando.setBounds(750, 300, 530, 30);
        main.add(processando);
        /*
                String [] nomeColunas ={"Codigo","Tipo de Cama","Preco Normal","Preco Reserva","Tipo de Quarto"};
        
        String [][]data = {
            {"ss","dd","ss","ss","ss"}
        };
       tab = new JTable(data,nomeColunas);
       sp = new JScrollPane(tab);
        sp.setBounds(600, 80, 700, 500);
         tab.setDefaultEditor(Object.class, null);
          main.add(sp);
       
      */
        jf.add(main);
        jf.setVisible(true);
        
        
    }
    
    
    public void setTable(String []colunaNames, String [][]data){
      if(sp != null){ sp.setVisible(false);
        main.remove(sp);}
       
       tab= new JTable(data,colunaNames);
               

        sp = new JScrollPane(tab);
              
                     sp.setBounds(600, 80, 700, 500);
              
             main.add(sp);
             sp.setVisible(true);
             
             
      
        
    
      
      
    }
    
    
    
    
    
    
    
     public CategoriaQuarto getObject(){
       // String 
      /* Object Empty =null;
       if(!combo[0].getSelectedItem().equals(Empty)){
           
           JOptionPane.showMessageDialog(null,  "Ja foi cadastrado");
        return null;
       }else{*/
       
       String tipoCama = (combo[0].getSelectedItem()).toString();
       String tipoQuarto=(combo[1].getSelectedItem()).toString();
       int precoNormal = Integer.parseInt(campo[1].getText());
       int precoReserva = Integer.parseInt(campo[2].getText());
       /* System.out.println(tipoCama);
        System.out.println(tipoQuarto);
        System.out.println(precoNormal);
        System.out.println(precoReserva);*/
       CategoriaQuarto cate = new CategoriaQuarto(tipoCama,precoNormal,precoReserva,tipoQuarto);
       return cate;
       
     //} 
    }
    
    
    public CategoriaQuarto getObjectWithID(){
       // String 
       String tipoCama = (combo[0].getSelectedItem()).toString();
       String tipoQuarto=(combo[1].getSelectedItem()).toString();
       int precoNormal = Integer.parseInt(campo[1].getText());
       int precoReserva = Integer.parseInt(campo[2].getText());
       /* System.out.println(tipoCama);
        System.out.println(tipoQuarto);
        System.out.println(precoNormal);
        System.out.println(precoReserva);*/
       CategoriaQuarto cate = new CategoriaQuarto(tipoCama,precoNormal,precoReserva,tipoQuarto);
       cate.setCodigo(Integer.parseInt(campo[0].getText()));
       return cate;
        
    }


   public void addActionListener(ActionListener action){
       for(int i =0; i<butao.length;i++){
           butao[i].addActionListener(action);
       }
   }
   
   public void addMouseListener (MouseListener mouse){
       tab.addMouseListener(mouse);
   }
    
   
    public static void main(String[] args) {
        new FormCategoriaQuarto();
    }

        
}
