package view_Inguana.Acessorios;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class RoundedJFormattedTextField extends JFormattedTextField {

    public RoundedJFormattedTextField(MaskFormatter formatter) {
        super(formatter);
        init();
    }

    private void init() {
        setOpaque(false);
        setBorder(BorderFactory.createCompoundBorder(
                new RoundedCornerBorder(),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        super.paintComponent(g);
    }

    private static class RoundedCornerBorder extends javax.swing.border.AbstractBorder {

        @Override
        public void paintBorder(java.awt.Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color oldColor = g.getColor();
            g.setColor(Color.BLACK);
            g.drawRoundRect(x, y, width - 1, height - 1, 20, 20);
            g.setColor(oldColor);
        }

    }
}
