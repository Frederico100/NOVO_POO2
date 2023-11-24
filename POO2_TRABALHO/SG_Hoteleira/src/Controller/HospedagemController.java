package Controller;

import DAO.ClienteDAO;
import DAO.HospedagemDAO;
import Model.CargoSalario;
import Model.CategoriaQuarto;
import Model.Cliente;
import Model.Funcionario;
import Model.Hospedagem;
import Model.Quarto;
import VIEW_PAPELA.FormCargoSalario;
import VIEW_PAPELA.FormCategoriaQuarto;
import VIEW_PAPELA.FormCliente;
import VIEW_PAPELA.FormFuncionario;
import VIEW_PAPELA.FormHospedagem;
import Controller.QuartoController;
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
import view_Inguana.PaineisD_Acesso.PaineslSHospedagem;

/**
 *
 * @author Frederico Papela
 */
public class HospedagemController {

    Hospedagem hospedagem;
    PaineslSHospedagem form;
    Tratadora trata = new Tratadora();

    public HospedagemController( PaineslSHospedagem form) {
        this.hospedagem = new Hospedagem();
        this.form = form;
        form.addActionListener(trata);

    }

    public void add(Hospedagem hospedagem) {
        new HospedagemDAO().insert(hospedagem);

    }

    public Hospedagem getObject() {
        Hospedagem hospedagem = form.getObject();
        return hospedagem;
    }
    
  

    public void consult() {
        ArrayList<Hospedagem> array = new HospedagemDAO().select();
        String[] nomeColunas = {"id", "dataInicio", "dataFim", "Valor_apagar", "numero_quarto", "bi_cliente"};

        String[][] data = new String[array.size()][10];

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        for (int i = 0; i < array.size(); i++) {
            data[i][0] = String.valueOf(array.get(i).getId());

            data[i][1] = sdf.format(array.get(i).getDataInicio());
            data[i][2] = sdf.format(array.get(i).getDataFim());
            data[i][3] = String.valueOf(array.get(i).getValorApagar());
            data[i][4] = String.valueOf(array.get(i).getNuquarto());
            data[i][5] = String.valueOf(array.get(i).getBi_cliente());
        }

        form.tabela = new JTable(data, nomeColunas);
        form.setTable(nomeColunas, data);
        form.tabela.setDefaultEditor(Object.class, null);
        form.addMouseListener(trata);
    }

    public void delete(Hospedagem hospedagem) {
        new HospedagemDAO().delete(hospedagem);
    }

    public void upgrade(Hospedagem hospedagem) {
        new HospedagemDAO().Update(hospedagem);
    }

    class Tratadora extends MouseAdapter implements ActionListener {
JTable refTaba,refTabb;
        public void mousePressed(MouseEvent mouseEvent) {

            if (mouseEvent.getSource() == form.tabcat) {
                System.out.println("cheguei ");
                if (mouseEvent.getClickCount() == 2 && form.tabcat.getSelectedRow() != -1) {

                    Point point = mouseEvent.getPoint();
                    int row = form.tabcat.rowAtPoint(point);
                    if(form.tabcat==refTabb){
                    String numeroqua = form.tabcat.getModel().getValueAt(row, 0).toString();
                    form.tfNQuarto.setText(numeroqua);
                    }
                    
                    if(form.tabcat == refTaba){
                    String bi_cliente =form.tabcat.getModel().getValueAt(row, 0).toString();
                    form.tfBI_Cliente.setText(bi_cliente);
                    }
                     
                    
                    
                    
                    /*                      
                    
//             cliente.setBiAtendente(codigo);
                    hospedagem.setBi_cliente(codigo);
                    if (form.tabcat.getColumnCount() == 8) {
                     //   form.campo[5].setText(codigo);
                    } else if (form.tabcat.getColumnCount() == 10) {
                        CategoriaQuarto cate = new CategoriaQuarto();
                        cate.setPreco_normal(Integer.parseInt(form.tabcat.getModel().getValueAt(row, 8).toString()));
                     //   form.campo[4].setText(String.valueOf(codigo));
                    } */

                    form.dailog.dispose();
                    // form.jfCategoria.remove(form.scrol);

                }
            }

            if (mouseEvent.getSource() == form.tabela) {
                Point point = mouseEvent.getPoint();
                //System.out.println("ponto " +point);
                int row = form.tabela.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && form.tabela.getSelectedRow() != -1) {

                    int colunas = form.tabela.getModel().getColumnCount();
                    int rows = form.tabela.rowAtPoint(point);
                    form.tfidho.setText((form.tabela.getModel().getValueAt(rows, 0)).toString());
                    form.tfDataInicio.setText((form.tabela.getModel().getValueAt(rows, 1)).toString());
       
                    form.tfDataFim.setText((form.tabela.getModel().getValueAt(rows, 2)).toString());
                    form.tfValorApagar.setText((form.tabela.getModel().getValueAt(rows, 3)).toString());
                     form.tfNQuarto.setText((form.tabela.getModel().getValueAt(rows, 4)).toString());
    
                    form.tfBI_Cliente.setText(form.tabela.getModel().getValueAt(rows, 5).toString());
                    //form.fBI_Cliente.getText().setText((form.tab.getModel().getValueAt(rows, i)).toString());
       
                     
       
                   
       
                  //      form.campo[i].setText((form.tab.getModel().getValueAt(rows, i)).toString());

                    }

                }
            }
        

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == form.bPickcli) {

                ClienteController con = new ClienteController();
                //    con.trata=null;
                refTaba=con.consult();
                form.popUp(refTaba);
                form.addMouseListenerTabCat(trata);

                // con.trata=null;
                //  
            }
            if (e.getSource() == form.bPickqua) {

                QuartoController cont;
                cont = new QuartoController();
                
                refTabb=cont.consult();
                form.popUp(refTabb);
                form.addMouseListenerTabCat(trata);

                //    form.campo[5].setText();
            }

            if (e.getSource() == form.bCadastro) {
                System.out.println("Adicionando no Banco de Dados Dados da Categoria Quarto");

                add(getObject());
                consult();
            }

            if (e.getSource() == form.bApagar) {
                System.out.println("Apagando Dados da Categoria Quarto");

               delete(form.getObjectWithID());
               consult();

            }
            if (e.getSource() == form.bActualizar) {
               upgrade(form.getObjectWithID());
               consult();
            }

            if (e.getSource() == form.bConsultar) {

                consult();

            }
            
            if (e.getSource() == form.bcalc) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String data = sdf.format(date);
                 form.tfDataInicio.setText(data);

                 Date dateFinal = new Date(form.tfDataFim.getText());

               float valorApagar = (dateFinal.getTime() - date.getTime()) / (1000 * 3600 * 24);
               //   form.campo[3].setText(String.valueOf(valorApagar*hospedagem.getQuarto().getCategoria().getPreco_normal()));
               form.tfValorApagar.setText(String.valueOf(valorApagar * 100));

            }

        }
    }
}
/*
    public static void main(String[] args) {
        Hospedagem hospedagem = new Hospedagem();
        FormHospedagem form = new FormHospedagem();
        // Clienclie = new Cliente();
        // FormCliente form = new FormCliente();

        new HospedagemController(hospedagem, form);

        // new ClienteController(clie, form);
    }*/


