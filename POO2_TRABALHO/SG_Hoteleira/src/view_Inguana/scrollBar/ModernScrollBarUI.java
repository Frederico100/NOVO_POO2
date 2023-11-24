package view_Inguana.scrollBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ModernScrollBarUI extends BasicScrollBarUI {

    private final int THUMB_SIZE = 40;

    @Override
    protected Dimension getMaximumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new ScrollBarButton();
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new ScrollBarButton();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle retangulo) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int orientacao = scrollbar.getOrientation();
        int size;
        int x;
        int y;
        int width;
        int heigth;
        if (orientacao == JScrollBar.VERTICAL) {
            size = retangulo.width / 2;
            x = retangulo.x + ((retangulo.width - size) / 2);
            y = retangulo.y;
            width = size;
            heigth = retangulo.height;
        } else {
            size = retangulo.height / 2;
            y = retangulo.y + ((retangulo.height - size) / 2);
            x = 0;
            width = retangulo.width;
            heigth = size;
        }
        g2.setColor(new Color(240, 240, 240));
        g2.fillRect(x, y, width, heigth);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle rect) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = rect.x;
        int y = rect.y;
        int width = rect.width;
        int heigth = rect.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 8;
            heigth -= 16;
        } else {
            x += 8;
            x -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, heigth, 10, 10);
    }
    
    private class ScrollBarButton extends JButton{

        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics g) {
        }
        
    }

}
