
package Controller;

import DAO.CargoSalarioDAO;
import Model.CargoSalario;
import Model.CategoriaQuarto;
import VIEW_PAPELA.FormCargoSalario;
import java.util.ArrayList;
import VIEW_PAPELA.FormCategoriaQuarto;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import view_Inguana.PaineisD_Acesso.PainelSCargoF;

/**
 *
 * @author Frederico Papela
 */
public class CargoSalarioController {
    CargoSalario  salario;
    
    PainelSCargoF form;
    Tratadora trata = new Tratadora();
        public CargoSalarioController(PainelSCargoF form){
            this.salario = new CargoSalario();  this.form=form;
            
            
            
            form.addActionListener(trata);
          
           
            
        }
        
         public CargoSalarioController(){
            salario = new CargoSalario();  
            form= new PainelSCargoF();
            
            
            
         //   form.addActionListener(trata);
          
           
            
        }
        
    
      public void add(CargoSalario cargoSalario){
         new CargoSalarioDAO().insert(cargoSalario);
     }
    
      public JTable consult(){
          System.out.println("getting in consult method");
         
        ArrayList<CargoSalario> array = new CargoSalario().consult();
        String [] nomeColunas ={"Codigo","Salario","Cargo"};
        
          String[][] data = new String[array.size()][5];
          for (int i = 0; i < array.size(); i++) {
              data[i][0] = String.valueOf(array.get(i).getCodigo_cargo());

              data[i][1] = String.valueOf(array.get(i).getSalario());
              data[i][2] = array.get(i).getCargo();
          }
        JTable tabel = new JTable(data,nomeColunas);
         form.setTable(nomeColunas, data);
         form.tabela.setDefaultEditor(Object.class, null);
         form.addMouseListener(trata);
         
         return tabel;
         
    
      }  
      public void delete(CargoSalario cargo){
          new CargoSalarioDAO().delete(cargo);
      }
      
      public void upgrade(CargoSalario cargo){
          new CargoSalarioDAO().Update(cargo);
      }
      
      
      class Tratadora extends MouseAdapter implements ActionListener{
         
        public void mousePressed(MouseEvent mouseEvent) {
            System.out.println("loadng...... just geted in mousepress for consult");
        if(mouseEvent.getSource()==form.tabela){
        Point point = mouseEvent.getPoint();
        //System.out.println("ponto " +point);
        int row = form.tabela.rowAtPoint(point);
            
       
      
        
        if (mouseEvent.getClickCount() == 2 && form.tabela.getSelectedRow() != -1) {
                       
             // System.out.println("row" + row);
            
            int colunas = form.tabela.getModel().getColumnCount();
           // System.out.println("colunas" + colunas);
            
        
          
           form.cbCargo.setSelectedItem(form.tabela.getModel().getValueAt(row, 2).toString());
           form.cbSalario.setSelectedItem(form.tabela.getModel().getValueAt(row, 1).toString());
           form.tfCodigo.setText(form.tabela.getModel().getValueAt(row, 0).toString());
      
    }}
        }

        
         
          
       
        public void actionPerformed(ActionEvent e) {
        
             if(e.getSource()==form.bCadastro){
                System.out.println("Adicionando no Banco de Dados Dados da Categoria Quarto");
                System.out.println(form.getObject());
                
                add(form.getObject());
               consult();
            }
            
            if(e.getSource()== form.bApagar){
                System.out.println("Apagando Dados da Categoria Quarto");
               delete(form.getObjectWithID());
                form.tabela.setVisible(false);
               
               consult();
                
            }
            if(e.getSource() == form.bActualizar){
                upgrade(form.getObjectWithID());
              form.tabela.setVisible(false);
                 consult();
                }
            
            if(e.getSource()==form.bConsultar){
                  consult();
     
            }
            
            
      
          
      
        }
        }
}
