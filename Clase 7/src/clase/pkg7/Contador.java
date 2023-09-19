package clase.pkg7;

// Clase que implementa la interfaz Runnable para representar la tarea que realizarán los hilos
public class Contador implements Runnable {

    private String nombre;
    
    // Constructor que recibe el nombre del hilo
    public Contador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hilo " + nombre + ": Contador = " + i); // Imprime el nombre del hilo y el contador
            try {
                Thread.sleep(1000); // Simular una tarea que lleva tiempo pausando el hilo durante 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
