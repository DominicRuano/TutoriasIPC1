package clase.pkg7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploSwing {

    private static JFrame frame;
    private static JPanel panel;
    private static JProgressBar progressBar;
    private static JButton startButton;

    public static void createGUI() {
        // Crear la ventana principal
        frame = new JFrame("Ejemplo Swing con Hilos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // Crear un panel para contener los componentes
        panel = new JPanel();
        progressBar = new JProgressBar(0, 100);
        startButton = new JButton("Iniciar Tarea");

        // Configurar el botón para responder al clic del usuario
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false); // Desactivar el botón mientras se ejecutan las tareas
                progressBar.setValue(0); // Reiniciar la barra de progreso

                // Crear un hilo para realizar la tarea en segundo plano
                Thread workerThread = new Thread(new Worker());
                workerThread.start();
            }
        });

        // Agregar componentes al panel
        panel.add(progressBar);
        panel.add(startButton);

        // Agregar el panel a la ventana y hacerla visible
        frame.add(panel);
        frame.setVisible(true);
    }

    private static class Worker implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(100); // Simular una tarea que lleva tiempo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int progress = i;
                // Actualizar la barra de progreso en el hilo de la GUI
                SwingUtilities.invokeLater(() -> {
                    progressBar.setValue(progress);
                    if (progress == 100) {
                        startButton.setEnabled(true); // Habilitar el botón cuando la tarea haya finalizado
                    }
                });
            }
        }
    }
}
