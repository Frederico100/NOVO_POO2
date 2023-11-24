package Acessorios;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.*;

public class TextFieldModificado extends JTextField {

    private int borderRadius = 15; // Ajuste o raio conforme necessário

    public TextFieldModificado(int columns) {
        super(columns);
        setOpaque(false); // Torna o componente transparente para que a forma arredondada seja visível
        setBorder(null);  // Remove a borda padrão
        setBackground(new Color(255, 255, 255));
        Font font = new Font("Segoe UI", Font.PLAIN, 14);
        setLayout(null);
        setFont(font);
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
    //TextField textField = new TextField(20);

}
