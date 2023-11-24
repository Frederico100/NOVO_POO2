package view_Inguana.Componente;

import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuAnimacao {

    public static void showMenu(Component comp, MenuItem item, MigLayout layout, boolean show) {
        int heigth = comp.getPreferredSize().height;
        Animator animator = new Animator(250, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                layout.setComponentConstraints(comp, "h " + heigth * f + "!");
                item.setAnimar(f);
                comp.revalidate();
                item.repaint();
            }

        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.start();
    }
}
