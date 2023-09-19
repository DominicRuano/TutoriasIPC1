package clase.pkg7;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class spawnLabelsSimplificado extends Thread {

    private JLabel label;
    private boolean moving = true;
    private JFrame frame;

    public spawnLabelsSimplificado(JLabel label, JFrame frame) {
        this.label = label;
        this.frame = frame;
    }

    @Override
    public void run() {
        //obtiene la altura de la ventana
        int windowHeight = frame.getHeight();
        // obtieen la altura del label
        int labelHeight = label.getHeight();
        int y = 0;

        while (moving) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            y += 10; // Mover 10 píxeles hacia abajo en cada iteración
            label.setLocation(label.getX(), y);
            // Eliminar el label cuando llegue al final de la pantalla
            if (y + labelHeight >= windowHeight) {
                moving = false;
                label.setVisible(false);
                label.getParent().remove(label);
            }
        }
    }
}
