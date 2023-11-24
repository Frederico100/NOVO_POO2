
package VIEW_PAPELA;

import Controller.CategoriaQuartoController;
import Model.CategoriaQuarto;
import java.util.ArrayList;

/**
 *
 * @author Frederico Papela
 */
public class Form {
     public boolean status = false;
    
    public Form(){
        System.out.println("Digite");
        
        
        String cargo="";
        
        FormCategoriaQuarto();
    }
  
    public boolean FormCargoSalario(){
        return status;
    }
    
    public boolean FormCategoriaQuarto(){
        
       String[] tipoQuarto ={"Normal","VIP"};
       // String [] categoria ={,true};
        int  precoNormal = 400;
        int precoVip = 800;
        String [] tipoCama ={"solteiro","casal"};
        
        CategoriaQuarto categoriaQuarto = new CategoriaQuarto(tipoCama[0],precoNormal,precoVip, tipoQuarto[0]);
       //s new CategoriaQuartoController().add(categoriaQuarto);
        
        return status;
    
            
    
    
    }
    
    public void consult(){
        
      ///  ArrayList<CategoriaQuarto> array = new  CategoriaQuartoController().consult();
        
        
        
        
      //  return array;
     } 
    
    public boolean FormFuncionario(){
        return status;
    }
    public boolean FormHospedagemReserva(){
     return status;
    }
    
    public boolean FormQuarto(){
        boolean disponivel = true;
        boolean ocupado = false;
        int andar =4;
        int telefone = 43372367;
        
        
              
        
        
        return status;
    }
    
    
    public static void main(String[] args) {
        new Form();
    }
    
}

