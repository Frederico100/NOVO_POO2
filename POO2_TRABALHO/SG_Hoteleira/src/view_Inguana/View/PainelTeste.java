package view_Inguana.View;

import Acessorios.Header;
import Controller.CargoSalarioController;
import Controller.CategoriaQuartoController;
import Controller.ClienteController;
import Controller.FuncionarioController;
import Controller.HospedagemController;
import Controller.QuartoController;
import view_Inguana.PaineisD_Acesso.PainelCliente;
import view_Inguana.PaineisD_Acesso.PainelInicio;
import view_Inguana.PaineisD_Acesso.PainelPadrao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view_Inguana.Componente.MenuCustomizado;
import view_Inguana.Componente.MenuEvent;
import view_Inguana.PaineisD_Acesso.PainelFuncionario;
import view_Inguana.PaineisD_Acesso.PainelRFuncionario;
import view_Inguana.PaineisD_Acesso.PainelRHospedagem;
import view_Inguana.PaineisD_Acesso.PainelRHospede;
import view_Inguana.PaineisD_Acesso.PainelRQuarto;
import view_Inguana.PaineisD_Acesso.PainelSCargoF;
import view_Inguana.PaineisD_Acesso.PainelSQuarto;
import view_Inguana.PaineisD_Acesso.PaineslSHospedagem;

public class PainelTeste extends JFrame {

    private JPanel pn, pn2, corpo;
    PainelPadrao pp;
    MenuCustomizado mc;

    public PainelTeste() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mc = new MenuCustomizado();
        //pp = new PainelPadrao();
        Header h = new Header();
        corpo = new JPanel();
        corpo.setBackground(new Color(89, 13, 165));
        corpo.setLayout(new BorderLayout());
         setBackground(Color.BLACK);
        pn = new JPanel();
        pn.setBackground(Color.DARK_GRAY);
        pn.setLayout(new BorderLayout());
        pn.setBackground(new Color(89, 13, 165));
        pn2 = new JPanel();
        pn2.setLayout(new BorderLayout());
        pn2.setPreferredSize(new Dimension(180, 0));
        pn2.setBackground(new Color(89, 13, 165));
        h.setPreferredSize(new Dimension(0, 50));
        pn2.add(mc, BorderLayout.NORTH);
        pn2.setBackground(new Color(89, 13, 165));
        pn.add(h, BorderLayout.NORTH);
        pn.add(corpo, BorderLayout.CENTER);
        pn.add(pn2, BorderLayout.WEST);

        mc.setEvento(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    showForm(new PainelInicio());
                } else if (index == 1 && subIndex == 1) {
                    System.out.println("LOADING....got in painel Funcionario");
                    PainelFuncionario pai = new PainelFuncionario();
                    new FuncionarioController(pai);
                    showForm(pai);
                } else if (index == 1 && subIndex == 2) {
                    PainelCliente pa  = new PainelCliente();
                    showForm(pa);
                    new ClienteController(pa);
                } else if (index == 1 && subIndex == 3) {
                    PainelSQuarto paQua = new PainelSQuarto();
                    showForm(paQua);
               
                    new QuartoController(paQua);
                } else if (index == 1 && subIndex == 4) {
                    PainelSCargoF ps = new PainelSCargoF();
                    new CargoSalarioController(ps);
                    showForm(ps);
                } else if (index == 2 && subIndex == 1) {
                    System.out.println("aqui !");
                 PaineslSHospedagem pa = new PaineslSHospedagem(); 
                    
                      new HospedagemController(pa);
                      showForm( pa );
                } else if (index == 3 && subIndex == 1) {
                    showForm(new PainelRFuncionario());
                } else if (index == 3 && subIndex == 2) {
                    showForm(new PainelRHospede());
                } else if (index == 1 && subIndex == 5) {
                   PainelRQuarto prq= new PainelRQuarto();
                    showForm(prq);
                    new CategoriaQuartoController(prq);
                } else if (index == 3 && subIndex == 4) {
                    showForm(new PainelRHospedagem());
                }

            }
        });

        add(pn);
        setSize(800, 500);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showForm(Component com) {
        corpo.removeAll();
        corpo.add(com);
        corpo.repaint();
        corpo.revalidate();
    }

    public static void main(String[] args) {
        new PainelTeste();
    }
}
