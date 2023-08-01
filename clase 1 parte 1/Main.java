/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1clase;

/**
 *
 * @author Dominic
 */
public class Main {
    
    public static void mi_metodo(int radio, double pi){
        System.out.println("esto es un metodo");
        double perimetro = radio*2*pi;
        System.out.println("el radio es: "+ radio+ "tiene un perimetro de: " + perimetro);
    }
    
    public static double mi_funcion(int radio, double pi){
        return 2*pi*radio;
    }

    public static void main(String[] args) {
        int miVariable = 5;
        final double PI = 3.1416;
        
        miVariable = 8;
        
        
        //System.out.println(2 <= 2); hola este es un comentario
        
        while (miVariable < 100){
            System.out.println("mi variable vale: " + miVariable);
            miVariable += 10;
        }
        
        System.out.println("--------------------------------------------");
        
        for (int i =0 ; i <= 10; i += 2){
            System.out.println("el valor de i es: " + i);
        }
        
        System.out.println("---------------------------------------------");
        
        do {
            System.out.println("estamos dentro del bucle while-do");
        } while (false);
        
        System.out.println("---------------------------------------------");
        
        if (miVariable > 10){
            System.out.println("la variable es menor a 10");
        }else{
            System.out.println("la variables no es menor a 10");
        }
        
        
        System.out.println("--------------------------------------------");
        
        String nombre = "miercoles";
        
        switch (nombre) {
            case "Lunes":
                System.out.println("hoy es lunes");
                break;
            case "Martes":
                System.out.println("hoy es martes");
                break;
            case "miercoles":
                System.out.println("hoy es miercoles");
                break;
            default:
                System.out.println("este no es un caso valido");
        }
        
        System.out.println("---------------------------------------------");
        
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            
            System.out.println("el valor de i es: " + i);
        }
        
        System.out.println("----------------------------------------------");
        
        int[] miArray = {1,2,3,4,5};
        
        //miArray[2] = 34;
        
        for (int numero : miArray) {
            System.out.println("el valor es: " + numero);
        }
        
        System.out.println("---------------------------------------------");
        
        int radio = 2;
       
        
        mi_metodo(radio,PI);
        radio = 3;
        mi_metodo(radio, PI);
        
        System.out.println("------------------------------------------------");
        
        System.out.println("el resultado de la funcion es: " + mi_funcion(radio, PI));
        radio = 5;
        System.out.println("el valor de la funcion con radio: " + radio+ " es: " + mi_funcion(radio, PI));
        
        
    }
    
}
