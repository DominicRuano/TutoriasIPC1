
package clase.pkg7;


public class EjemploThreadPool {
    public static void prueba(int tareaID){
        System.out.println("Tarea " + tareaID + " ejecutándose en el hilo: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000); // Simula una tarea que lleva tiempo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tarea " + tareaID + " completada en el hilo: " + Thread.currentThread().getName());
    }
}
