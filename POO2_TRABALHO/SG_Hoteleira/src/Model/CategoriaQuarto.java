package Model;

import DAO.CategoriaQuartoDao;
import java.util.ArrayList;

public class CategoriaQuarto {
    private int codigo;
    private String tipo_de_cama;
    private int preco_normal;
    private int preco_reserva;
    private String tipoQuarto;
    
    public CategoriaQuarto(){}

    public CategoriaQuarto( String tipo_de_cama, int preco_normal, int preco_reserva, String tipoQuarto) {
      
        this.tipo_de_cama = tipo_de_cama;
        this.preco_normal = preco_normal;
        this.preco_reserva = preco_reserva;
        this.tipoQuarto = tipoQuarto;
    }
    
    
            
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTipo_de_cama() {
        return tipo_de_cama;
    }
    public void setTipo_de_cama(String tipo_de_cama) {
        this.tipo_de_cama = tipo_de_cama;
    }
    public int getPreco_normal() {
        return preco_normal;
    }
    public void setPreco_normal(int preco_normal) {
        this.preco_normal = preco_normal;
    }
    public int getPreco_reserva() {
        return preco_reserva;
    }
    public void setPreco_reserva(int preco_reserva) {
        this.preco_reserva = preco_reserva;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }
  
     public void add(CategoriaQuarto cateQuarto){
         new CategoriaQuartoDao().insert(cateQuarto);
     }
     
     public ArrayList<CategoriaQuarto> consult(){
         
        ArrayList<CategoriaQuarto> categoria =  new CategoriaQuartoDao().select();
        
        return categoria;
         
     }
     
    
     public void delete(CategoriaQuarto catQuarto){
         new CategoriaQuartoDao().delete(catQuarto);
     }
     
     public void upgrade(CategoriaQuarto catQuarto){
         new CategoriaQuartoDao().Update(catQuarto);
     }

    
    public String toString() {
        return "CategoriaQuarto{" + "codigo=" + codigo + ", tipo_de_cama=" + tipo_de_cama + ", preco_normal=" + preco_normal + ", preco_reserva=" + preco_reserva + ", tipoQuarto=" + tipoQuarto + '}';
    }
   
     

}
