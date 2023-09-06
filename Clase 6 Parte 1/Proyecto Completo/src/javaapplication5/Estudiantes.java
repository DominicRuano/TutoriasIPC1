/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;
import java.io.Serializable;

/**
 *
 * @author samuel
 */
public class Estudiantes implements Serializable{
    String nombre;
    String apellido;
    int edad;
    String carnet;

    public Estudiantes(String nombre, String apellido, int edad, String carnet) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carnet = carnet;
    }
    
    public String getNombe() {   
        return this.nombre;
    }
    
    void getNombe(String nombre) {   
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public int getEdad() {
        return this.edad;
    }
    
    public String getCarnet() {
        return this.carnet;
    }
   
    
    
}
