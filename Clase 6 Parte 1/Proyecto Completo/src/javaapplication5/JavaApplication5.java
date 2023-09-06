/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author samuel
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int contador = 0;
//        Estudiantes[] listaEstudiantes = new Estudiantes[30];
        Estudiantes[] DatosGuardados = new Estudiantes[30];
//        
//        listaEstudiantes[0] = new Estudiantes("Juan", "Perez", 22, "21001119");
//        listaEstudiantes[1] = new Estudiantes("Carlos", "Gutierres", 21, "21001119");
//        listaEstudiantes[2] = new Estudiantes("Manuel", "Zelada", 40, "45454356");
//        listaEstudiantes[3] = new Estudiantes("Lucia", "Pereira", 32, "3453543");
//        listaEstudiantes[4] = new Estudiantes("Paola", "Perez", 33, "443345345");
//        listaEstudiantes[5] = new Estudiantes("Sebastian", "Perez", 44, "4554543");
//        listaEstudiantes[6] = new Estudiantes("Hola", "Mundo", 44, "4554543");
//        
//        
////        for (int x=0; x < listaEstudiantes.length; x++) {
////            if (listaEstudiantes[x] != null) {
////                System.out.println(listaEstudiantes[x].nombre + " " + listaEstudiantes[x].apellido);
////            }                
////        }
//        
//        try(ObjectOutputStream escritura=new ObjectOutputStream(new FileOutputStream("Datos.txt"))) {           
//            for (int x=0; x < listaEstudiantes.length; x++) {
//                if (listaEstudiantes[x] != null) {
//                    escritura.writeObject(listaEstudiantes[x]);
//                    System.out.println("Datos cargados correctamente...");
//                }                
//            }           
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
        
        
        try(ObjectInputStream lectura=new ObjectInputStream(new FileInputStream("Datos.txt"))) {
            
            while (true) {
                Estudiantes linea=(Estudiantes)lectura.readObject();
                //System.out.println(linea.nombre + " " + linea.apellido + " " + linea.edad + " " + linea.carnet);
                DatosGuardados[contador] = new Estudiantes(linea.nombre, linea.apellido, linea.edad , linea.carnet);
                contador = contador+1;       
            }
            
        } catch (ClassNotFoundException e) {           
        } catch (EOFException e) {            
        } catch (IOException e) {           
        }

        
        
        for (int x=0; x < DatosGuardados.length; x++) {
            if (DatosGuardados[x] != null) {
                System.out.println(DatosGuardados[x].nombre + " " + DatosGuardados[x].apellido);
            }                
        }
        
        System.out.println(DatosGuardados[5].apellido + " " + DatosGuardados[5].carnet);
           
        
        
 
        
    }
    
}
