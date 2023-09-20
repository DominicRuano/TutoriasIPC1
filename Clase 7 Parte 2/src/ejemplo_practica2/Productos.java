/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_practica2;
import java.io.Serializable;

/**
 *
 * @author samuel
 */

// Clase para guardar los datos de productos, importante que sea Serializable
public class Productos implements Serializable{
    
    int id;
    String producto;
    int precio;

    // metodo constructor
    public Productos(int id, String producto, int precio) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
    }

    
    // Metodos Get
    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public int getPrecio() {
        return precio;
    }

    // Metodo set
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    
    
    
    
    
}
