
package Controller;


import DAO.FuncionarioDAO;
import Model.CargoSalario;
import Model.CategoriaQuarto;
import Model.Funcionario;
import Model.Quarto;
import VIEW_PAPELA.FormCargoSalario;
import VIEW_PAPELA.FormCategoriaQuarto;
import VIEW_PAPELA.FormFuncionario;
import VIEW_PAPELA.FormQuarto;
import java.util.ArrayList;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import view_Inguana.PaineisD_Acesso.PainelFuncionario;

/**
 *
 * @author Frederico Papela
 */
public class FuncionarioController {
    
    Funcionario funcionario;
    PainelFuncionario form;
    Tratadora trata = new Tratadora();
        public FuncionarioController(PainelFuncionario form){
            this.funcionario = new Funcionario();  this.form=form;
            
            
            
            form.addActionListener(trata);
            
           
            
        }
        
         public FuncionarioController(){
               
            form = new PainelFuncionario();
            funcionario =new Funcionario();
            form.addActionListener(trata);
            //form.setVisible(false);
         //  form.addActionListener(trata);
            
           
            
        }
    
    
      public void add(Funcionario funcionario){
          
           new FuncionarioDAO().insert(funcionario);
         
     }
      
      public Funcionario getObject(){
         
          CargoSalario cargos = funcionario.getCargo();
          Funcionario funcio = form.getObject();
          funcio.setCargo(cargos);
        
          return funcio; 
      }
          
      
   
      public JTable consult(){
          System.out.println("IN....consult method");
        ArrayList<Funcionario> array = new Funcionario().consult();
        

        String [] nomeColunas ={"BI"," Nome "," Idade "," Sexo "," Telefone "," Endereco "," Ano de Admissao "," Codigo_Cargo "," Salario "," Cargo "};
        
          String[][] data = new String[array.size()][10];
          for (int i = 0; i < array.size(); i++) {
              data[i][0] = String.valueOf(array.get(i).getBi());

              data[i][1] = array.get(i).getNome();
              data[i][2] = String.valueOf(array.get(i).getIdade());
              data[i][3] = String.valueOf(array.get(i).getSexo());
              data[i][4] = array.get(i).getTelefone();
              data[i][5] =array.get(i).getEndereco();
              data[i][6]= array.get(i).getAno_de_adimissao();
              data[i][7]= String.valueOf(array.get(i).getCargo().getCodigo_cargo());
              data[i][8]= String.valueOf(array.get(i).getCargo().getSalario());
              data[i][9]= String.valueOf(array.get(i).getCargo().getCargo());
          }
        
        // form.tab = new JTable(data,nomeColunas);
        JTable tab = new JTable(data,nomeColunas);
         form.setTable(nomeColunas, data);
         form.tabela.setDefaultEditor(Object.class, null);
         form.addMouseListener(trata);
         
         return tab;

        }
 
      
      public void delete(Funcionario funcionario){
                new Funcionario().delete(funcionario);
      }
      
      public void upgrade(Funcionario funcionario){
            new Funcionario().update(funcionario);
      }
      

      class Tratadora extends MouseAdapter implements ActionListener{
          
        public void mousePressed(MouseEvent mouseEvent) {
            
            
        if(mouseEvent.getSource()==form.tabcatpf){
            if (mouseEvent.getClickCount() == 2 && form.tabcatpf.getSelectedRow() != -1) {
        
          
             Point point = mouseEvent.getPoint();
             int row = form.tabcatpf.rowAtPoint(point);
              
             int codigo = Integer.parseInt(form.tabcatpf.getModel().getValueAt(row, 0).toString());
             double salario = Double.parseDouble(form.tabcatpf.getModel().getValueAt(row, 1).toString());
             String cargoSalario = form.tabcatpf.getModel().getValueAt(row, 2).toString();
            
             CargoSalario cargo = new CargoSalario(salario,cargoSalario);
             cargo.setCodigo_cargo(codigo);
             
             funcionario.setCargo(cargo);
             
            
                form.tfCd_Cargo.setText(String.valueOf(cargo.getCodigo_cargo()));
               
                form.dialog.dispose();
                form.dialog.remove(form.scrolpf);
           
            }
        }
         
        if(mouseEvent.getSource()==form.tabela){
        Point point = mouseEvent.getPoint();
        //System.out.println("ponto " +point);
        int row = form.tabela.rowAtPoint(point);
            
       
      
       
        if (mouseEvent.getClickCount() == 2 && form.tabela.getSelectedRow() != -1) {
                       
              
             
                int cod = Integer.parseInt(form.tabela.getValueAt(row, 7).toString());
                double salario = Double.parseDouble(form.tabela.getModel().getValueAt(row, 8).toString());
                String cargo = form.tabela.getModel().getValueAt(row, 9).toString();
            
                  CargoSalario cat = new CargoSalario(salario,cargo);
                  cat.setCodigo_cargo(cod);
                  
                  funcionario.setCargo(cat);
               
                  int colunas = form.tabela.getModel().getColumnCount();
                  int rows =form.tabela.rowAtPoint(point);
                  
                  form.tfnomepf.setText(form.tabela.getModel().getValueAt(rows, 1).toString());
                  form.tfIdadepf.setText(form.tabela.getModel().getValueAt(rows, 2).toString());
                  form.tfBIpf.setText(form.tabela.getModel().getValueAt(rows, 0).toString());
                  form.tfCd_Cargo.setText(form.tabela.getModel().getValueAt(rows, 7).toString());
                  form.tfContactopf.setText(form.tabela.getModel().getValueAt(rows, 4).toString());
                  form.tfEnderecopf.setText(form.tabela.getModel().getValueAt(rows, 5).toString());
                  form.cbsexpf.setSelectedItem(form.tabela.getModel().getValueAt(rows, 3).toString());
                  form.tfAnoAdmissaopf.setText(form.tabela.getModel().getValueAt(rows, 6).toString());
         
         //   form.campo[k].setText((form.tabela.getModel().getValueAt(rows, i)).toString());
            
              
                
             
                 
             //    form.combo[j].setSelectedItem(form.tabela.getModel().getValueAt(rows, i));
                  
             
   
        
        }
        
        }
        }

        
         
          
       
        public void actionPerformed(ActionEvent e) {
              if(e.getSource() == form.bPick){
                  
                  System.out.println("Loading.......... Getting in action event of btPICK");
       
                  CargoSalarioController categoria = new CargoSalarioController();  
                   
                  form.popUp(categoria.consult());
                
                  form.addMouseListenerTabCatg(trata);
            
        }    
            
            
             if(e.getSource()==form.bCadastro){
                System.out.println("Adicionando no Banco de Dados Dados da Categoria Quarto");
               
                Funcionario fun = getObject();
                CargoSalario cag = funcionario.getCargo();
                fun.setCargo(cag);
                add(fun);
               consult();
            }
            
            if(e.getSource()== form.bApagar){
                System.out.println("Apagando Dados da Categoria Quarto");
          
                 delete(getObject());
                  consult();
                
                
            }
            if(e.getSource() == form.bActualizar){
         Funcionario fun = getObject();
                CargoSalario cag = funcionario.getCargo();
                fun.setCargo(cag);
              upgrade(fun);
                consult();
                }
            
            if(e.getSource()==form.bConsultar){
                 
               consult();
                
     
            }
            
            
        }      
      }
  
}
