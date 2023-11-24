package view.ComponentesUI;

import Ferrament_Componet.TextFieldModificado;
import Ferrament_Componet.JButtonModificado;
import java.awt.*;
import javax.swing.*;

public class PainelOpCadastro extends JPanel {

    private JPanel painel1, painel2;
    private JLabel l1, l2, l3, l4;
    private JButtonModificado bt1, bt2, bt3, bt4, bt5, bt6, bt7;
    private TextFieldModificado tf;
    
    public PainelOpCadastro() {
        setLayout(new CardLayout());
        setBackground(Color.DARK_GRAY);
        bt1 = new JButtonModificado();
        bt2 = new JButtonModificado();
        bt3 = new JButtonModificado();
        bt4 = new JButtonModificado();
        bt5 = new JButtonModificado();
        bt6 = new JButtonModificado();
        bt7 = new JButtonModificado();
     
        bt1.setText("Cadastrar Funcionário");
        bt2.setText("Cadastrar Funcionário");
        bt3.setText("Cadastrar Funcionário");
        
        painel1 = new JPanel();
        painel1.setLayout(null);
        
        bt1.setBounds(500, 300, 300, 50);
        bt2.setBounds(500, 400, 300, 50);
        bt3.setBounds(500, 500, 300, 50);
        
        painel1.add(bt1);
        painel1.add(bt2);
        painel1.add(bt3);
    }

}
