
package Controller;

import DAO.CategoriaQuartoDao;
import Model.CategoriaQuarto;
import java.util.ArrayList;
import VIEW_PAPELA.FormCategoriaQuarto;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import  view_Inguana.PaineisD_Acesso.PainelRQuarto;

/**
 *
 * @author Frederico Papela
 */
public class CategoriaQuartoController {
    
    CategoriaQuarto categoria ;
    //FormCategoriaQuarto form;
    PainelRQuarto form;
    Tratadora trata = new Tratadora();
        public CategoriaQuartoController(PainelRQuarto form){
            categoria = new CategoriaQuarto();  this.form=form;
            
            
            
            form.addActionListener(trata);
          
           
            
        }
        
       public CategoriaQuartoController(){
           categoria= new CategoriaQuarto();
           form = new PainelRQuarto();
           form.setVisible(false);
           form.addActionListener(trata);
       }
    
      public void add(CategoriaQuarto categoriaQuarto){
         new CategoriaQuartoDao().insert(categoriaQuarto);
     }
    
     
      public JTable consult(){
         
        ArrayList<CategoriaQuarto> array = new CategoriaQuarto().consult();
        String [] nomeColunas ={"Codigo","Tipo de Cama","Preco Normal","Preco Reserva","Tipo de Quarto"};
        
          String[][] data = new String[array.size()][5];
          for (int i = 0; i < array.size(); i++) {
              data[i][0] = String.valueOf(array.get(i).getCodigo());

              data[i][1] = array.get(i).getTipo_de_cama();
              data[i][2] = String.valueOf(array.get(i).getPreco_normal());
              data[i][3] = String.valueOf(array.get(i).getPreco_reserva());
              data[i][4] = array.get(i).getTipoQuarto();}
        
          
          JTable tab = new JTable(data,nomeColunas);
         form.setTable(nomeColunas, data);
         form.tabela.setDefaultEditor(Object.class, null);
         form.addMouseListener(trata);
         
         return tab;
         
     }
      
      
      public ArrayList<CategoriaQuarto> info(){

    return  new CategoriaQuarto().consult();
}
      
      public void delete(CategoriaQuarto categoriaQuarto){
          new CategoriaQuartoDao().delete(categoriaQuarto);
      }
      
      public void upgrade(CategoriaQuarto categoriaQuarto){
          new CategoriaQuartoDao().Update(categoriaQuarto);
      }
      
      
      class Tratadora extends MouseAdapter implements ActionListener{
          
        public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getSource()==form.tabela){
        Point point = mouseEvent.getPoint();
        //System.out.println("ponto " +point);
        int row = form.tabela.rowAtPoint(point);
            
       
      
        
        if (mouseEvent.getClickCount() == 2 && form.tabela.getSelectedRow() != -1) {
                       
            
            int colunas = form.tabela.getModel().getColumnCount();
          
           form.cbCama.setSelectedItem(form.tabela.getModel().getValueAt(row, 1));
           form.cbQuarto.setSelectedItem(form.tabela.getModel().getValueAt(row, 4));
           form.tfCodigo.setText(form.tabela.getModel().getValueAt(row, 0).toString());
           form.tfPreco.setText(form.tabela.getModel().getValueAt(row, 2).toString());
           form.tfPrecoReserva.setText(form.tabela.getModel().getValueAt(row, 3).toString());
          
         
           
        
    }
}
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
