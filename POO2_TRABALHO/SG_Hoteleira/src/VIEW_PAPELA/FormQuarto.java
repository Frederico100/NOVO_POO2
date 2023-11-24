
package VIEW_PAPELA;


import Model.CategoriaQuarto;
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
public class FormQuarto  {
    
    public JButton [] butao ;
    public JLabel [] label ;
    public JTextField [] campo ;
    public  JComboBox [] combo;
    public JPanel main,tabela;
    public JTable tab;
    public JButton pick;
    JScrollPane sp;
    public JFrame jf,jfCategoria;
   public  JTable tableCategoria ;
   public JScrollPane scrol;
    // JTextField campoCodigo, campoPreco;
    public FormQuarto(){
        
     
        main = new JPanel(null);
        combo = new JComboBox[3];
        butao = new JButton[4];
        label = new JLabel[6];
        campo = new JTextField[4];
         jfCategoria = new JFrame();
        
        String [] infoLabel = {"Numero do Quarto ","Disponivel", "Ocupado","Andar", "Telefone ","codCategoria"};
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
            if(i==0 || i==3){campo[i].setEditable(false);}
            
            main.add(campo[i]);
           if(i==0){ yCampo+=180;} else{yCampo+=60;}
        }
         String[] disponivel ={"Sim","Nao"};
         String [] ocupado={"Sim", "Nao"};
         String []andar ={"1","2","3","4","5","6"};
         ArrayList<String[]> tipo = new ArrayList<String[]>();
         tipo.add(disponivel); tipo.add(ocupado); tipo.add(andar);
         
         int yCombo=140;
         
        for (int i =0 ; i< 2;i++){
            combo[i]=new JComboBox(tipo.get(i));
            
            combo[i].setBounds(xLabel+130,yCombo , 100, 30);
            main.add(combo[i]);
            yCombo +=60;
        }
        
        
        
        
        
        JLabel topLeft = new JLabel("Insira / Remova / Apague os dados do Quarto aqui !");
        JLabel topRight = new JLabel("Registros do Quarto");
        
        topLeft.setBounds(270, 30, 500, 30);
        topRight.setBounds(850, 30, 200, 30);
        main.add(topLeft); main.add(topRight);
        
        JLabel processando = new JLabel("AGUARDE!........PROCESSANDO OS DADOS DO QUARTO......");
        processando.setBounds(750, 300, 530, 30);
        main.add(processando);
       
        
        pick= new JButton("Pick");
        pick.setBounds(540, 380, 100, 30);
        main.add(pick);
        
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
    
    
    public void popUp(ArrayList<CategoriaQuarto> array){
        
        
        String [] nomeColunas ={"Codigo","Tipo de Cama","Preco Normal","Preco Reserva","Tipo de Quarto"};
        
          String[][] data = new String[array.size()][5];
          for (int i = 0; i < array.size(); i++) {
              data[i][0] = String.valueOf(array.get(i).getCodigo());

              data[i][1] = array.get(i).getTipo_de_cama();
              data[i][2] = String.valueOf(array.get(i).getPreco_normal());
              data[i][3] = String.valueOf(array.get(i).getPreco_reserva());
              data[i][4] = array.get(i).getTipoQuarto();}
        
         tableCategoria = new JTable(data,nomeColunas);
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
    
     public Quarto getObject(){
    
      
       String telefone =  campo[2].getText();
       int andar =  Integer.parseInt(campo[1].getText());
      String disponivel = combo[0].getSelectedItem().toString();
      String ocupado = combo[1].getSelectedItem().toString();
             System.out.println("disponivel " + disponivel);
         System.out.println("ocupado..." + ocupado);
   
     
   
      CategoriaQuarto categoria =null;
      
       Quarto quarto = new Quarto (telefone,ocupado,disponivel,andar,categoria);
         if(!campo[0].getText().isEmpty()){
         int codigo =Integer.parseInt(campo[0].getText());
          quarto.setNumero(codigo);
      }

      
   return quarto;
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
        new FormQuarto();
    }
  
}
