/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2;

import java.util.Scanner;

/**
 *
 * @author samuel
 */
public class Clase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        /* 
        Si desean comentar una parte del codigo para pobrar pueden utilizar las barras dobles
        // para que ese codigo no se ejecute, o seleccionar lo que no quieren usar combinar
        Ctrl + /
        */
        
        // Hacer uso de la libreria Scanner y utiliza el nombre sc
        // importante sc.next() para texto y sc.nextInt() para numeros enteros, existen mas opciones...
        Scanner sc = new Scanner(System.in);
    
        
        String usuario = "Samuel";
        String password = "holamundo";

        
        // Ingreso de datos por consola, usuario y contrase;a
        System.out.print("Ingrese su Usuario: ");
        
        // importante sc hacemos uso de scanner
        String user = sc.next();
        System.out.print("Ingrese sus Contra: ");
        String contra = sc.next();
        
        
        // Condicion, verifica que la variable user y contra sean igual a mis credenciales
        if ((user.equals("Samuel")) && (contra.equals("holamundo"))){ 
            
            // En caso correcto nos da la bienvenida
            System.out.print("Los datos son correctos, Bienvenido");       
        } else {
            
            // de lo contrario datos incorrectos
            System.out.print("Datos incorrectos, Denegado"); 
        }
        
        System.out.println("\n\n\n");

        // Declaracion de arreglo o array de tipo String con 10 valores de uso
        String nombres[] = new String[10];
        
        // Asignacion de datos al Array "nombres"
        nombres[0] = "Carlos";
        nombres[1] = "Samuel";
        nombres[2] = "Brandon";
        nombres[3] = "Denis";    
        nombres[9] = "Hola mundo";
        
        // Recorrer los datos dela arreglo
        for (int x=0; x <= 9; x++){
            // Imprime cada uno de los datos almacenados en el arreglo
            System.out.println(x + ". " + nombres[x]);
        }
        
        
        System.out.println("\n\n\n");


        
        // MENUS CON JAVA
        // declaracion de la opcion para el menu
        int opcionMenu = 0;
        
        // para los menu es mejo utilizar do while para asegurar que el menu se ejecuta al menos una vez
        do {
            
            // opciones de uso
            System.out.println("1. Ingresar como Administrador");
            System.out.println("2. Ingresar como Cliente");
            System.out.println("3. Salir");
            System.out.print("Ingresa una opcion: ");
            opcionMenu = sc.nextInt();
            
            // Switch es como un if, else if, else, pero de una manera mas simple y ordenada
            // es necesario parar la variable con la que se tomaran los datos -> "opcion Menu"
            switch(opcionMenu){
                
                // opcion en caso que la opcion sea "1"
                case 1:
                    System.out.println(" +++ ADMINISTRADOR +++\n\n\n");
                    int opcionMenuAdmin = 0;
                    
                    System.out.print("Ingrese su Usuario: ");
                    String userAdmin = sc.next();
                    System.out.print("Ingrese sus Contra: ");
                    String contraAdmin = sc.next();
                    
                    // Toma de datos y verificacion.  lo mismo que al inicio de este programa
                    if ((userAdmin.equals("Samuel")) && (contraAdmin.equals("holamundo"))){           
                        System.out.print("Los datos son correctos, Bienvenido");       
                    } else {
                        System.out.print("Datos incorrectos, Denegado\n\n");
                        
                        // Importante este break para que nuestro programa salga en 
                        // caso que los datos no sean correctos
                        break;                 
                    }
                    
                    
                    // inicio de Menu admin
                    do {
                        
                        // Menu de administrador. visible unicamente si el usuario y contrase;a son correctos
                        System.out.println("\n\n1. Agregar Vehiculo");
                        System.out.println("2. Agregar Descuento");
                        System.out.println("3. Realizar Reportes");
                        System.out.println("4. Mostrar Usuarios");
                        System.out.println("5. Regresar al Menu Principal");
                        System.out.print("Ingrese una opcion: ");
                        opcionMenuAdmin = sc.nextInt();
                      
                      // Reptir el codigo hasta que "opcionMenuAdmin sea menor que 5" 
                      // en caso que no se cumpla sale del bucle
                    } while (opcionMenuAdmin < 5);
                    
            }
        
        // Reptir el codigo hasta que "opcionMenu sea menor que 3"         
        } while (opcionMenu < 3);           
    }   
}
