package clase.pkg2;

public class Recursividad {
    
    
    //EJERCICIO 1
    public static int calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calcularFactorial(n - 1);
            //5*4*3*2*1
        }
    }
    
    
    //EJERCICIO 2
    // Función recursiva para calcular el N-ésimo término de la secuencia de Fibonacci
    public static int calcularFibonacci(int n) {
        // Caso base: el primer término de la secuencia es 0
        // 1,1,2,3,5,8
        if (n == 0) {
            return 0;
        } // Caso base: el segundo término de la secuencia es 1
        else if (n == 1) {
            return 1;
        } // Caso general: calcular el término sumando los dos términos anteriores
        else {
            // La función se llama a sí misma con n-1 y n-2 para obtener los términos anteriores
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }
    
    
    //EJERCICO 3
    //Función A que llama a B
    public static int funcionA(int n) {
        if (n <= 0) {
            System.out.println("Función A: Fin de la recursión");
            return 0;
        } else {
            System.out.println("Función A: Llamando a Función B con n = " + n);
            int result = n + funcionB(n - 1); // Llamada a la Función B
            System.out.println("Función A: Resultado parcial: " + result);
            return result;
        }
    }

    // Función B llama a la Función A
    public static int funcionB(int n) {
        if (n <= 0) {
            System.out.println("Función B: Fin de la recursión");
            return 0;
        } else {
            System.out.println("Función B: Llamando a Función A con n = " + n);
            int result = n + funcionA(n - 1); // Llamada a la Función A
            System.out.println("Función B: Resultado parcial: " + result);
            return result;
        }
    }
}
