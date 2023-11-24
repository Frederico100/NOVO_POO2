package Acessorios;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class JButtonModificado extends JButton {

    private boolean isHover = false;
    private Color defaultColor = new Color(105, 255, 153);
    private Color clickedColor = new Color(255, 153, 153);

    public JButtonModificado() {
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        setBorder(null);
        setBackground(defaultColor);
        setLayout(null);
        setFocusPainted(isHover);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(clickedColor);
                repaint();
            }
            /*
            @Override
            public void mouseEntered(MouseEvent e) {
                setContentAreaFilled(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!getModel().isPressed()) {
                    setContentAreaFilled(false);
                }
            }*/
        });
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color color = getModel().isPressed() ? clickedColor : defaultColor;

        g2.setColor(color);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

        super.paintComponent(g);
    }

}
