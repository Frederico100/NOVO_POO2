package view_Inguana.Componente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.sound.midi.Patch;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MenuItem extends JButton {

    private int index;
    private boolean subMenu;
    private int subMenuIndex;
    private int length;
    private float animar;

    public float getAnimar() {
        return animar;
    }

    public void setAnimar(float animar) {
        this.animar = animar;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSubMenu() {
        return subMenu;
    }

    public void setSubMenu(boolean subMenu) {
        this.subMenu = subMenu;
    }

    public int getSubMenuIndex() {
        return subMenuIndex;
    }

    public void setSubMenuIndex(int subMenuIndex) {
        this.subMenuIndex = subMenuIndex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public MenuItem(String name, int index, boolean subMenu) {
        super(name);
        this.index = index;
        this.subMenu = subMenu;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setPreferredSize(new Dimension(180, 30));
        setForeground(new Color(230, 230, 230));
        setBorder(new EmptyBorder(9, 10, 9, 10));
        setHorizontalAlignment(SwingConstants.LEFT);
        setIconTextGap(10);
        setBackground(new Color(89, 13, 165));
        setOpaque(true);
    }

    void initSubMenu(int subMenuIndex, int length) {
        this.subMenuIndex = subMenuIndex;
        this.length = length;
        setBorder(new EmptyBorder(9, 33, 9, 10));
        setBackground(new Color(127,41,188));
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (length != 0) {
            g2.setColor(new Color(122, 8, 199));
            if (subMenuIndex == 1) {
                // Primeiro Indice
                g2.drawLine(18, 0, 18, getHeight());
                g2.drawLine(18, getHeight() / 2, 26, getHeight() / 2);
            } else if (subMenuIndex == length - 1) {
                // Ultimo Indice
                g2.drawLine(18, 0, 18, getHeight() / 2);
                g2.drawLine(18, getHeight() / 2, 26, getHeight() / 2);
            } else {
                g2.drawLine(18, 0, 18, getHeight());
                g2.drawLine(18, getHeight() / 2, 26, getHeight() / 2);
            }

        } else if (subMenu) {
            g2.setColor(getForeground());
            int arrowWidth = 8;
            int arrowHeigth = 4;
            Path2D p = new Path2D.Double();
            p.moveTo(0, arrowHeigth * animar);
            p.lineTo(arrowWidth / 2, (1f - animar) * arrowHeigth);
            p.lineTo(arrowWidth, arrowHeigth * animar);
            g2.translate(getWidth() - arrowWidth - 15, (getHeight() - arrowHeigth) / 2);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.draw(p);
        }
        g2.dispose();
    }

}
