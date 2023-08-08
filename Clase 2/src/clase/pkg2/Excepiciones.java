package clase.pkg2;

import java.util.Scanner;

public class Excepiciones {

    static Scanner scanner = new Scanner(System.in);

    //Método para obtener entradas unicamente enteros
    public static int ingresarEnteros(String texto) {
        int valor = 0;
        try {
            System.out.print(texto);
            valor = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("× ERROR " + "Solo se admiten números Enteros");
        }
        return valor;
    }

    public static int divisioNumeros() {
        try {
            System.out.print("Ingrese el dividendo: ");
            int dividend = scanner.nextInt(); // Lee el dividendo ingresado por el usuario

            System.out.print("Ingrese el divisor: ");
            int divisor = scanner.nextInt(); // Lee el divisor ingresado por el usuario

            return dividend / divisor; // Realizar la división
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        } finally {
            scanner.close(); // Cierra el objeto Scanner para liberar recursos
        }
    }
}
