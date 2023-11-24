package Acessorios;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.*;

public class PasswordText extends JPasswordField {

    private int borderRadius = 10;
 
    public PasswordText(int colunas) {
        super(colunas);
        setOpaque(false); // Torna o componente transparente para que a forma arredondada seja visível
        setBorder(null);
        setBackground(new Color(255, 255, 255));
        Font font = new Font("SorgoeUI", Font.PLAIN, 14);
        setFont(font);
        setLayout(null);
        setFocusCycleRoot(true);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        int margin = borderRadius / 2;
        return new Insets(margin, margin, margin, margin);
    }

}
