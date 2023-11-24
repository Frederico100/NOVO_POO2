package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Paulo
 */
public class Hospedagem {

    // static Quarto quarto = new Quarto();
    // static Cliente cliente = new Cliente();
    private int id;
   /* private int diaFim;
    private int anoFim;
    private int mesFim;
    private long valorApagar;
    private String reservado;
    */
    private float valorApagar;
    private Date dataInicio ;
    private Date dataFim;
    private int nuquarto;
    private String bi_cliente;

    public Hospedagem(){}
    
    public Hospedagem(float valorApagar, Date dataInicio, Date dataFim, int quarto, String bi_cliente) {
        
        this.valorApagar = valorApagar;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.nuquarto = quarto;
        this.bi_cliente = bi_cliente;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNuquarto() {
        return nuquarto;
    }

    public void setNuquarto(int nuquarto) {
        this.nuquarto = nuquarto;
    }

   
    
    
    
/*
    public int getDiaFim() {
        return diaFim;
    }

    public void setDiaFim(int diaFim) {
        this.diaFim = diaFim;
    }

    public int getAnoFim() {
        return anoFim;
    }

    public void setAnoFim(int anoFim) {
        this.anoFim = anoFim;
    }

    public int getMesFim() {
        return mesFim;
    }

    public void setMesFim(int mesFim) {
        this.mesFim = mesFim;
    }
    public String getReservado() {
        return reservado;
    }

    public void setReservado(String reservado) {
        this.reservado = reservado;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getValorApagar() {
        Date data = new Date();
        SimpleDateFormat formatoano = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatomes = new SimpleDateFormat("MM");
        SimpleDateFormat formatodias = new SimpleDateFormat("dd");

        int ano = Integer.parseInt(formatoano.format(data));
        int mes = Integer.parseInt(formatomes.format(data));
        int dia = Integer.parseInt(formatodias.format(data));

        LocalDate inicio = LocalDate.of(ano, mes, dia);
        LocalDate fim = LocalDate.of(anoFim, mesFim, diaFim);

        long dias = ChronoUnit.DAYS.between(inicio, fim);

      //  long valor_a_pagar = dias * quarto.getPreco_normal();

        return valorApagar;
    }  */
  


    public float getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(float valorApagar) {
        this.valorApagar = valorApagar;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getBi_cliente() {
        return bi_cliente;
    }

    public void setBi_cliente(String bi_cliente) {
        this.bi_cliente = bi_cliente;
    }

    

  
   
}
