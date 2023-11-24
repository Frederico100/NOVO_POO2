package Model;

import DAO.QuartoDAO;
import java.util.ArrayList;



/**
 *
 * @author Paulo
 */
public class Quarto {

    private int numero;
    private String telefone;
    private String ocupado;
    private String disponibilidade;
    private int andar;
    private CategoriaQuarto categoria;

    public Quarto(){}
    
    public Quarto(String telefone, String ocupado, String disponibilidade, int andar, CategoriaQuarto categoria) {
        this.telefone = telefone;
        this.ocupado = ocupado;
        this.disponibilidade = disponibilidade;
        this.andar = andar;
        this.categoria = categoria;
       
    }
   


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getOcupado() {
        return ocupado;
    }

    public void setOcupado(String ocupado) {
        this.ocupado = ocupado;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String desponibilidade) {
        this.disponibilidade = desponibilidade;
    }

    

    public CategoriaQuarto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaQuarto categoria) {
        this.categoria = categoria;
    }
   
    
    public void add(Quarto quarto){
        new QuartoDAO().insert(quarto);
    }
    
    public ArrayList<Quarto> consult (){
    return new QuartoDAO().select();
    
}
    
    public void delete(Quarto quarto){
        new QuartoDAO().delete(quarto);
    }
    
    public void upgrade(Quarto quarto){
        new QuartoDAO().Update(quarto);
    }

    @Override
    public String toString() {
        return "Quarto{" + "numero=" + numero + ", telefone=" + telefone + ", ocupado=" + ocupado + ", disponibilidade=" + disponibilidade + ", andar=" + andar + ", categoria=" + categoria + '}';
    }

   
    
    
}
