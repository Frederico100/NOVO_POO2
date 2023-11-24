package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Paulo
 */
public  class  Cliente extends Pessoa {

    private int BiAtendente;
    private Date data_do_registro;
  
    public Cliente (){
        
    }

    public Cliente(String bi, String nome, int idade, char sexo, String endereco, String telefone, Date data_do_registro,int BiAtendente){
        super(bi,  nome, idade, sexo, endereco, telefone);
        this.data_do_registro = data_do_registro;
        this.BiAtendente=BiAtendente;
    }

   

    public void setData_do_registro(Date data_do_registro) {
        this.data_do_registro = data_do_registro;
    }

    public Date getData_do_registro() {
        return data_do_registro;
    }
    
    
   
    
    
    public String getData_do_registroString() {

        Date data = new Date();
        SimpleDateFormat formatoano = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatomes = new SimpleDateFormat("MM");
        SimpleDateFormat formatodias = new SimpleDateFormat("dd");

        String ano = formatoano.format(data);
        String mes = formatomes.format(data);
        String dia = formatodias.format(data);

        return   ano + "/" + mes + "/" + dia;
       
    }
    
    

    public int dia() {

        Date data = new Date();
    
        SimpleDateFormat formatodias = new SimpleDateFormat("dd");
        int dia = Integer.parseInt(formatodias.format(data));

        return dia;
    }

   
   

//    public static void main(String[] args) {
//        Cliente c = new Cliente();
//
//        System.out.println(c.getGetData_do_registro());
//
//    }

    public int getBiAtendente() {
        return BiAtendente;
    }

    public void setBiAtendente(int BiAtendente) {
        this.BiAtendente = BiAtendente;
    }

    @Override
    public String toString() {
        return super.toString()+ "Cliente{" + "BiAtendente=" + BiAtendente + ", data_do_registro=" + data_do_registro + '}';
    }


}
