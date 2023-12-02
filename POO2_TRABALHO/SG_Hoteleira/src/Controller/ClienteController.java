
package Controller;


import DAO.ClienteDAO;
import Model.CargoSalario;
import Model.CategoriaQuarto;
import Model.Cliente;
import Model.Funcionario;
import Model.Quarto;
import VIEW_PAPELA.FormCargoSalario;
import VIEW_PAPELA.FormCategoriaQuarto;
import VIEW_PAPELA.FormCliente;
import VIEW_PAPELA.FormFuncionario;
import VIEW_PAPELA.FormQuarto;
import java.util.ArrayList;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import view_Inguana.PaineisD_Acesso.PainelCliente;

/**
 *
 * @author Frederico Papela
 */
public class ClienteController {
    
    Cliente cliente;
    PainelCliente form;
    Tratadora trata = new Tratadora();
        public ClienteController 
        
        
        (PainelCliente form){
            this.cliente = new Cliente();  this.form=form;
            
            
               form.addActionListener(trata);
            // form.jf.setVisible(false);
            
           
            
        }
        
        public ClienteController(){
        cliente= new Cliente();  
        form  = new PainelCliente();
        //form.addActionListener(trata);
      
        //form.jf.setVisible(false);
     
        }
    
      public void add(Cliente cliente){
          
           new ClienteDAO().insert(cliente);
          
         
     }
      
      public Cliente getObject(){
          Cliente cliente = form.getObject();
          
        
           return cliente;
      }
             
    
      public JTable consult(){
        
        ArrayList<Cliente> array = new ClienteDAO().select();
        

        String [] nomeColunas ={"Bi","nome","idade","sexo","Telefone","endereco","data_do_registro","Bi_Funcionario"};
        
          String[][] data = new String[array.size()][10];
          for (int i = 0; i < array.size(); i++) {
              data[i][0] = String.valueOf(array.get(i).getBi());

              data[i][1] = array.get(i).getNome();
              data[i][2] = String.valueOf(array.get(i).getIdade());
              data[i][3] = String.valueOf(array.get(i).getSexo());
              data[i][4] = array.get(i).getTelefone();
              data[i][5] =array.get(i).getEndereco();
              data[i][6] = String.valueOf(array.get(i).getData_do_registro());
              data[i][7] = String.valueOf(array.get(i).getBiAtendente());
           
          }
        
         JTable tab= new JTable(data,nomeColunas);
      
         form.setTable(nomeColunas, data);
        
         form.tabela.setDefaultEditor(Object.class, null);
         form.addMouseListener(trata);
         
      //    System.out.println("aaa" + form.tabela.getValueAt(0, 0));
         
          return tab;
          
        }
  
      
      public void delete(Cliente cliente){
                new ClienteDAO().delete(cliente);
      }
      
      public void upgrade(Cliente cliente ){
            new ClienteDAO().Update(cliente);
      }
      

      class Tratadora extends MouseAdapter implements ActionListener{
          
        public void mousePressed(MouseEvent mouseEvent) {
           
      if(mouseEvent.getSource()==form.tabcat){
            if (mouseEvent.getClickCount() == 2 && form.tabcat.getSelectedRow() != -1) {
        
          
             Point point = mouseEvent.getPoint();
             int row = form.tabcat.rowAtPoint(point);
              
             String codigo = form.tabcat.getModel().getValueAt(row, 0).toString();
            
             cliente.setBiAtendente(codigo);
             
            
                form.tfCdfuncio.setText(String.valueOf(cliente.getBiAtendente()));
               
                form.dialog.dispose();
                form.dialog.remove(form.scrol);
           
            } 
        }
          
       
       
        if(mouseEvent.getSource()==form.tabela){
        Point point = mouseEvent.getPoint();
        //System.out.println("ponto " +point);
        int row = form.tabela.rowAtPoint(point);
            
       
      
        if (mouseEvent.getClickCount() == 2 && form.tabela.getSelectedRow() != -1) {
                       
              
             
               
             
            int colunas = form.tabela.getModel().getColumnCount();
            int rows =form.tabela.rowAtPoint(point);
            int k=0; int j =0;
            for(int i =0; i<colunas; i++){
                        
              
            // form.campo[k].setText((form.tab.getModel().getValueAt(rows, i)).toString());
                    
                  form.tfnome.setText(form.tabela.getModel().getValueAt(rows, 1).toString());
                  form.tfIdade.setText(form.tabela.getModel().getValueAt(rows, 2).toString());
                  form.tfBI.setText(form.tabela.getModel().getValueAt(rows, 0).toString());
                  //form.tfCd_Cargo.setText(form.tabela.getModel().getValueAt(rows, 7).toString());
                  form.tfContacto.setText(" "+form.tabela.getModel().getValueAt(rows, 4).toString());
                  form.tfEndereco.setText(form.tabela.getModel().getValueAt(rows, 5).toString());
                  form.cbsex.setSelectedItem(form.tabela.getModel().getValueAt(rows, 3).toString());
                 // form.tfAnoAdmissao.setText(form.tabela.getModel().getValueAt(rows, 6).toString());
                   
                 form.tfCdfuncio.setText(form.tabela.getModel().getValueAt(rows,7).toString());
              
                    
                    String day =  form.tabela.getModel().getValueAt(rows, 6).toString();
                    System.out.println(day);
                    System.out.println("day " + day);
                     String year="" , mes="", dia="";    
                    for (int m =0 ; m<10 ; m++){
                      //  System.out.println(day.charAt(0));
                        if(m<4){ year += day.charAt(m);
                            System.out.println(year);}
                        else if(m==5 || m==6){mes += day.charAt(m);}
                        else if (m>7){
                            dia+=day.charAt(m);
                        }
                    }
                    String fullDay= year+"/"+mes+"/"+dia;
                    
                    form.tfDateRegistro.setText(fullDay);
                  
                
              
             //    form.combo[j].setSelectedItem(form.tab.getModel().getValueAt(rows, i));
              
        }
    } 
}
  }

        
         
          
       
        public void actionPerformed(ActionEvent e) {
            
              if(e.getSource() == form.bPick){
                  SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
                  form.tfDateRegistro.setText( sdf.format(new Date()));
                //  form.tfDateRegistro.setText("44441212");
                 
                  System.out.println("in action evente of bpick");
                //  System.out.println(sdf.format(new Date()));
                  FuncionarioController fun = new FuncionarioController();
                  
                  
                  fun.trata=null;
                  
                  
                  form.popUp(fun.consult());
                   form.addMouseListenerTabCatg(trata);
                 
            
        }    
            
            
             if(e.getSource()==form.bCadastro){
                System.out.println("Adicionando no Banco de Dados Dados da Categoria Quarto");
               
                
                
                
                Cliente cli = getObject();
               // cli.setData_do_registro(new Date(new Cliente().getData_do_registroString()));
                add(cli);
               consult();
            }
            
            if(e.getSource()== form.bApagar){
                System.out.println("Apagando Dados da Categoria Quarto");
          
                delete(getObject());
                   consult();
                
                
            }
            if(e.getSource() == form.bActualizar){
         
                upgrade(getObject());
                consult();
                }
            
            if(e.getSource()==form.bConsultar){
                 
                consult();
                
     
            }
           // if(e.getSource()==form.pick2){
               
             
          //  }
            
           
        }      
      }
          
      
 
}
