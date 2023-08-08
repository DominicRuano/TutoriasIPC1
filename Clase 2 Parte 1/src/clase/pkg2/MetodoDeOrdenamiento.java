
package clase.pkg2;

import java.util.Arrays;


public class MetodoDeOrdenamiento {
    
    public static void ordenarBurbuja(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {   // Recorre el array n - 1 veces
            for (int j = 0; j < n - i - 1; j++) { // Últimos i elementos ya están ordenados
                if (arr[j] > arr[j + 1]) {
                    // Intercambia arr[j] y arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
        //System.out.println(Arrays.toString(arr));
    }
    
     public static void ordenarInsercion(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {   // Comienza desde el segundo elemento
            int key = arr[i];
            int j = i - 1;
            
            // Mueve los elementos del subarreglo que son mayores que key una posición adelante
            // Mueve los elementos menores a la izquierda
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;  // Inserta el elemento key en su posición correcta
            //System.out.println(Arrays.toString(arr));
        }
        // Imprime el arreglo ordenado
        System.out.println(Arrays.toString(arr));
    }
}
