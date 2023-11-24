package view_Inguana.Componente;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class MenuCustomizado extends JComponent {

    private MenuEvent evento;
    private MigLayout layout;
    private String[][] menuItem = new String[][]{
        {"Início"},
        {"Cadastro", "Funcionário", "Hospede", "Quarto", "Cargo do Funcionario", "Categoria Quartos"},
        {"Serviços", "Hospedagem"},
        {"Registros", "Funcionario", "Hospede", "Hospedagem"},};

    public MenuCustomizado() {
        init();
        setBorder(null);
    }

    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);

        for (int i = 0; i < menuItem.length; i++) {
            addMenu(menuItem[i][0], i);
        }
    }

    private Icon getIcon(int index) {
        URL url = getClass().getResource("/view_Inguana/icones/" + index + ".png");

        if (url != null) {
            return new ImageIcon(url);
        } else {
            return null;
        }

    }

    private void addMenu(String MenuName, int index) {
        int length = menuItem[index].length;
        MenuItem item = new MenuItem(MenuName, index, length > 1);
        Icon icon = getIcon(index);
        if (icon != null) {
            item.setIcon(icon);
        }
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (length > 1) {
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    } else {
                        // Oculta
                        ocultarMenu(item, index);
                        item.setSelected(false);
                    }
                } else {
                    if (evento != null) {
                        evento.selected(index, 0);
                    }
                }
            }
        });
        add(item);
        revalidate();
        repaint();
    }

    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel pn = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
        pn.setName(index + "");
        pn.setOpaque(false);
        pn.setBackground(new Color(89, 13, 165));
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuItem[index][i], i, false);
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (evento != null) {
                        evento.selected(index, subItem.getIndex());
                    }
                }
            });
            subItem.initSubMenu(i, length);
            pn.add(subItem);
        }
        add(pn, "h 0!", indexZorder + 1);
        revalidate();
        repaint();
        MenuAnimacao.showMenu(pn, item, layout, true);
    }

    private void ocultarMenu(MenuItem item, int index) {
        for (Component com : getComponents()) {
            if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
                com.setName(null);
                MenuAnimacao.showMenu(com, item, layout, false);
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setBackground(new Color(21, 110, 71));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));

        super.paintComponent(g);
    }

    public MenuEvent getEvento() {
        return evento;
    }

    public void setEvento(MenuEvent evento) {
        this.evento = evento;
    }
}
