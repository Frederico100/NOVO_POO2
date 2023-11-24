
package VIEW_PAPELA;


import Model.CargoSalario;
import Model.CategoriaQuarto;
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
public class FormFuncionario  {
    
    public JButton [] butao ;
    public JLabel [] label ;
    public JTextField [] campo ;
    public  JComboBox [] combo;
    public JPanel main,tabela;
    public JTable tab;
    public JButton pick;
    JScrollPane sp;
    public JFrame jf,jfCargo;
   public  JTable tableCargo ;
   public JScrollPane scrol;
    // JTextField campoCodigo, campoPreco;
    public FormFuncionario(){
        
     
        main = new JPanel(null);
        combo = new JComboBox[1];
        butao = new JButton[4];
        label = new JLabel[8];
        campo = new JTextField[7];
         jfCargo = new JFrame();
        
        String [] infoLabel = {"BI","Nome", "Idade","Sexo", "Telefone ","Endereco","Ano de Admissao","Codigo Cargo"};
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
        int xButao = 270; int yButao =680;
        
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
            if( i==8){campo[i].setEditable(false);}
            
            main.add(campo[i]);
            
            if(i==2){yCampo += 60;}
            
           yCampo+=60;
        }
         String[] sexovet ={"M","F"};
         
        
         
         int yCombo=260;
         
        for (int i =0 ; i< 1;i++){
            combo[i]=new JComboBox(sexovet);
          
            combo[i].setBounds(xLabel+130,yCombo , 100, 30);
            main.add(combo[i]);
           
           // yCombo +=60;
        }
        
        
        
        
        
        JLabel topLeft = new JLabel("Insira / Remova / Apague os dados do Funcionario aqui !");
        JLabel topRight = new JLabel("Registros do Funcionario");
        
        topLeft.setBounds(270, 30, 500, 30);
        topRight.setBounds(850, 30, 200, 30);
        main.add(topLeft); main.add(topRight);
        
        JLabel processando = new JLabel("AGUARDE!........PROCESSANDO OS DADOS DO FUNCIONARIO......");
        processando.setBounds(750, 300, 530, 30);
        main.add(processando);
       
        
        pick= new JButton("Pick");
        pick.setBounds(540, 620, 100, 30);
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
    
    
    public void popUp(ArrayList<CargoSalario> array){
        
        
        String [] nomeColunas ={"Codigo","Salario","Cargo"};
        
          String[][] data = new String[array.size()][3];
          for (int i = 0; i < array.size(); i++) {
              data[i][0] = String.valueOf(array.get(i).getCodigo_cargo());
              data[i][1] = String.valueOf(array.get(i).getSalario());
              data[i][2] = array.get(i).getCargo();}
        
         tableCargo = new JTable(data,nomeColunas);
         tableCargo.setDefaultEditor(Object.class, null);
         scrol = new JScrollPane(tableCargo); 

        //table.addMouseListener(trata);
         
        
        jfCargo.setSize(700,700);
        jfCargo.setLocationRelativeTo(null);
        jfCargo.add(scrol);
        jfCargo.setVisible(true);
    }
    
    
    
    
    
    public int inter(String string){
        return Integer.parseInt(string);
    }
    
     public Funcionario getObject(){
    
      
         String bi = campo[0].getText();
         String nome = campo[1].getText();
         int idade = Integer.parseInt(campo[2].getText());
         char sexo  = (combo[0].getSelectedItem().toString()).charAt(0);
         String telefone =  campo[3].getText();
         String endereco =  campo[4].getText();
         String ano = campo[5].getText();
       
         CargoSalario cargo = null;
         
         Funcionario funcionario = new Funcionario(bi,nome,idade,sexo,telefone,endereco,ano,cargo);
    
      
   return funcionario;
     }
    
    
   
    /*
    public void consultaCategoria(){
  
        JPanel pa = new JPanel();
        jfCargo.add(pa); jfCargo.setVisible(true);
        
    }
*/

   public void addActionListener(ActionListener action){
        pick.addActionListener(action);
       for(int i =0; i<butao.length;i++){
           butao[i].addActionListener(action);
           
        
       }
       
          
       
       
   }
   
   public void addMouseListener (MouseListener mouse){
         
         tableCargo.addMouseListener(mouse);
   }
   public void addMouseListenerTab (MouseListener mouse){
       tab.addMouseListener(mouse);
   }
    
    public static void main(String[] args) {
        new FormFuncionario();
    }
}
