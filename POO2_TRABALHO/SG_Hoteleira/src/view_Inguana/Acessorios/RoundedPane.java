package Acessorios;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundedPane extends JPanel {

    private int radius;

    public RoundedPane() {
        // O raio padrão é 20
        this.radius = 35;
        setBorder(null);
        setLayout(null);
        setOpaque(false);
    }

    public RoundedPane(int radius) {
        // Permite especificar o raio ao criar o painel
        this.radius = radius;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Certifique-se de chamar o método da classe pai
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }

    //RoundedPane roundedPane = new RoundedPane(30); // Usará um raio de 30
}
