
package Controller;


import DAO.QuartoDAO;
import Model.CategoriaQuarto;
import Model.Quarto;
import VIEW_PAPELA.FormCategoriaQuarto;
import VIEW_PAPELA.FormQuarto;
import java.util.ArrayList;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import view_Inguana.PaineisD_Acesso.PainelSQuarto;

/**
 *
 * @author Frederico Papela
 */
public class QuartoController {
    
    Quarto quarto ;
    PainelSQuarto form;
    Tratadora trata = new Tratadora();
        public QuartoController(PainelSQuarto form){
            this.quarto = new Quarto();  this.form=form;
            
            
            
            form.addActionListener(trata);
            
           
            
        }
    public QuartoController(){
        quarto = new Quarto();
        form = new PainelSQuarto();
       
    }
      public void add(Quarto Quarto){
          new QuartoDAO().insert(Quarto);
         
     }
     
    
      public JTable consult(){
         
        ArrayList<Quarto> array = new Quarto().consult();
        

        String [] nomeColunas ={"Numero do Quarto"," Disponivel "," Ocupado ","Andar","Telefone"," CodigoCategoria","Tipo de Cama","Preco Normal","Preco Reserva","Tipo de Quarto"};
        
          String[][] data = new String[array.size()][10];
          for (int i = 0; i < array.size(); i++) {
              data[i][0] = String.valueOf(array.get(i).getNumero());

              data[i][1] = array.get(i).getDisponibilidade();
              data[i][2] = array.get(i).getOcupado();
              data[i][3] = String.valueOf(array.get(i).getAndar());
              data[i][4] = array.get(i).getTelefone();
              data[i][5] =String.valueOf(array.get(i).getCategoria().getCodigo());
              data[i][6]= array.get(i).getCategoria().getTipo_de_cama();
              data[i][7]= String.valueOf(array.get(i).getCategoria().getPreco_normal());
              data[i][8]= String.valueOf(array.get(i).getCategoria().getPreco_reserva());
              data[i][9]= String.valueOf(array.get(i).getCategoria().getTipoQuarto());
          }
        JTable tabel = new JTable(data,nomeColunas);
         form.setTable(nomeColunas, data);
         form.tabela.setDefaultEditor(Object.class, null);
         form.addMouseListenerTab(trata);
         
         return tabel;
      }
      
      public void delete(Quarto quarto){
          new QuartoDAO().delete(quarto);
      }
      
      public void upgrade(Quarto quarto){
           new QuartoDAO().Update(quarto);
      }
      

      class Tratadora extends MouseAdapter implements ActionListener{
        
        public void mousePressed(MouseEvent mouseEvent) {
              
        if(mouseEvent.getSource()==form.tabcat){
            if (mouseEvent.getClickCount() == 2 && form.tabcat.getSelectedRow() != -1) {
        
            
             Point point = mouseEvent.getPoint();
               int row = form.tabcat.rowAtPoint(point);
              
             String tipoCama = form.tabcat.getModel().getValueAt(row, 1).toString();
              String tipoQuarto = form.tabcat.getModel().getValueAt(row, 4).toString();
             int precoNormal = Integer.parseInt(form.tabcat.getModel().getValueAt(row, 2).toString());
             int precoReserva = Integer.parseInt(form.tabcat.getModel().getValueAt(row, 3).toString());
       
      
       CategoriaQuarto cate = new CategoriaQuarto(tipoCama,precoNormal,precoReserva,tipoQuarto);
           
       cate.setCodigo(Integer.parseInt(form.tabcat.getModel().getValueAt(row, 0).toString()));
                quarto.setCategoria(cate);
                System.out.println("WORKING.............");
             
       
                form.tfCd_Categoria.setText(String.valueOf(cate.getCodigo()));
               
                form.dailog.dispose();
                form.dailog.remove(form.scrol);
           
            }
        }
            
        if(mouseEvent.getSource()==form.tabela){
        Point point = mouseEvent.getPoint();
        //System.out.println("ponto " +point);
        int row = form.tabela.rowAtPoint(point);
            
       
      
        
        if (mouseEvent.getClickCount() == 2 && form.tabela.getSelectedRow() != -1) {
                       
          
             
              String tipoCama = form.tabela.getModel().getValueAt(row, 6).toString();
              String tipoQuarto = form.tabela.getModel().getValueAt(row, 9).toString();
             int precoNormal = Integer.parseInt(form.tabela.getModel().getValueAt(row, 7).toString());
             int precoReserva = Integer.parseInt(form.tabela.getModel().getValueAt(row, 8).toString());
       int rows =form.tabela.rowAtPoint(point);
      
       CategoriaQuarto cate = new CategoriaQuarto(tipoCama,precoNormal,precoReserva,tipoQuarto);
                int codCategoria =Integer.parseInt(form.tabela.getModel().getValueAt(row, 5).toString());
            System.out.println(codCategoria);
                 cate.setCodigo(codCategoria);
                quarto.setCategoria(cate);
               
             
            int colunas = form.tabela.getModel().getColumnCount();
          
            form.tfCodigo.setText(form.tabela.getModel().getValueAt(rows, 0).toString());
            form.cbDisponibilidade.setSelectedItem(form.tabela.getModel().getValueAt(rows, 1));
            form.cbOcupacao.setSelectedItem(form.tabela.getModel().getValueAt(rows, 2));
              form.tfAndar.setText(form.tabela.getModel().getValueAt(rows, 3).toString());   
               form.tfContacto.setText(" "+form.tabela.getModel().getValueAt(rows, 4).toString());
               System.out.println("Imprimindo.........." + form.tabela.getModel().getValueAt(rows, 0).toString());
                form.tfCd_Categoria.setText(form.tabela.getModel().getValueAt(rows, 5).toString());
                 
           
            
    }
        }
        }
      
        
         
          
       
        public void actionPerformed(ActionEvent e) {
              if(e.getSource() == form.bgetcat){
                  
                  CategoriaQuartoController cat  = new CategoriaQuartoController();
                   System.out.println("chegei");
                  form.popUp(cat.consult());
                  form.addMouseListener(trata);
            
        }    
            
            
             if(e.getSource()==form.bCadastro){
                System.out.println("Adicionando no Banco de Dados Dados da Categoria Quarto");
               
                Quarto qua = form.getObject();
                qua.setCategoria(quarto.getCategoria());
                add(qua);
                consult();
            }
           
            if(e.getSource()== form.bApagar){
                System.out.println("Apagando Dados da Categoria Quarto");
                   Quarto qua = form.getObject();
                   qua.setCategoria(quarto.getCategoria());
                   delete(qua);
                   consult();
                
                
            }
            if(e.getSource() == form.bActualizar){
                Quarto qua = form.getObject();
                qua.setCategoria(quarto.getCategoria());
                 upgrade(qua);
                consult();
                }
           
            if(e.getSource()==form.bConsultar){
                 
                consult();               
     
            } 
            
            
        }      
      }
          
      
      
}
