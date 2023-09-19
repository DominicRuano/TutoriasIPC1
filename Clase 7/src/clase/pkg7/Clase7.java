package clase.pkg7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Clase7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ejemploThreadP();
        //ejemploS();
        //concurrencia();
        //ejemploInicio();
        //ejemploThreadP();
        //ejemploS();
        spawn();
    }

    public static void crearHilos() {
        Thread hilo1 = new Thread(new Contador("Hilo 1"));
        Thread hilo2 = new Thread(new Contador("Hilo 2"));

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
    }

    public static void concurrencia() {
        Thread t1 = new TareaEnParalelo(1);
        Thread t2 = new TareaEnParalelo(2);
        Thread t3 = new TareaEnParalelo(3);

        t1.start();
        t2.start();
        t3.start();
    }

    public static void ejemploInicio() {
        Thread t1 = new TareaEnParalelo(1);
        Thread t2 = new TareaEnParalelo(2);
        Thread t3 = new TareaEnParalelo(3);

        t1.run();
        t2.run();
        t3.run();
    }

    public static void ejemploThreadP() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Enviar tareas al ThreadPool
        for (int i = 1; i <= 5; i++) {
            int tareaID = i;
            executor.submit(() -> EjemploThreadPool.prueba(tareaID));
        }

        // Cerrar el ThreadPool cuando ya no se necesite
        executor.shutdown();
    }

    public static void ejemploS() {
        // se utiliza para asegurarse de que las actualizaciones de la interfaz de usuario se realicen en el hilo
        // de la interfaz de usuario
        SwingUtilities.invokeLater(() -> {
            EjemploSwing.createGUI();
        });
    }

    public static void spawn() {
        SwingUtilities.invokeLater(() -> {
            // Crear una ventana JFrame
            JFrame frame = new JFrame("Label Mover");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            JLabel label = new JLabel("Mueve este label");
            frame.add(label);
            // Configurar la posición inicial del JLabel en la parte superior
            label.setBounds(0, 0, label.getPreferredSize().width, label.getPreferredSize().height); // Configura la posición inicial en la parte superior
            // Crear un hilo para mover el JLabel
            spawnLabelsSimplificado moverThread = new spawnLabelsSimplificado(label, frame);
            moverThread.start();

            frame.setLayout(null); // Desactiva el diseño automático para que la posición absoluta funcione
            frame.setVisible(true);
        });
    }

}
