/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_practica2;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.java.accessibility.util.GUIInitializedListener;

/**
 *
 * @author samuel
 */
public class Ejemplo_practica2 {

    /**
     * @param args the command line arguments
     */
    
    // contador general de datos
    public static int idProducto = 0;
    
    /* 
        Lo mas importante de la practica es esto, trabajen las listas de este modo
        para que se les haga mas facil acceder a ellas desde cualquier punto, recuerden que tiene que ser public y static
        si aprenden bien a usar esto todo se vuelve mucho mas facil
    
        recuerden que para acceder a la lista desde otro archivo, se hace referencia a la clase y luego a la lista
        --> Ejemplo_practica2.listaProductos 
    */
    public static Productos[] listaProductos = new Productos[100];
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        // Lectura del archivo de Serializacion donde se guardaron todos los datos de la lista de productos
        // Importante que este codigo vaya junto, aveces da error si hay saltos de linea
        try (ObjectInputStream lectura=new ObjectInputStream(new FileInputStream("DatosProductos.txt"))) {
            while (true) {
                Productos aux=(Productos)lectura.readObject();   
                idProducto = aux.getId() + 1;
                // Lee el archivo y almacena los valores en la lista, debido a que cuando se cierra se recetea
                listaProductos[aux.getId()] = new Productos(aux.getId(), aux.getProducto(), aux.getPrecio());
                System.out.println("Datos recuperados de : " + aux.getProducto());
                
            }
        } catch (ClassNotFoundException e){   
        } catch (EOFException e) {
        } catch (IOException e) { 
        }
        
        
        // Inicia la interfaz grafica
        Incio interfaz = new Incio();
        interfaz.setVisible(true);
    }
           
}
