/*
 * El método partición toma el último elemento como pivote y coloca todos los elementos
 * menores que el pivote a su izquierda y todos los mayores a su derecha.
 * Luego, devuelve el índice del pivote.
 * 
 * Dado un array desordenado, ordenarlo utilizando 
 * quicksort. Utilizar el código base que está en 
 * el repo de la materia
 * 
 * array : tamaño fijo | arraylist : dinámico y solo objetos
 */

import java.util.Arrays;

public class Actividad3 {
    public static int partición(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto]; // se elige el último elemento como pivote
        int i = (bajo - 1); // índice del elemento más pequeño

        for (int j = bajo; j < alto; j++) {
            // si el elemento actual es menor o igual al pivote
            if (arreglo[j] <= pivote) {
                i++;
                // intercambio arreglo[i] con arreglo[j]
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        // intercambio el pivote con el elemento de la posición i+1
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;
        return i + 1; // índice de la partición
    }

    public static void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            // encontramos el índice de partición
            int indiceParticion = partición(arreglo, bajo, alto);

            // ordenamos los elementos antes y después de la partición
            quickSort(arreglo, bajo, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, alto);
        }
    }

    public static void main(String[] args) {
        int[] desordenado = {354, 6757, 213, 80, 34, 87};
        
        
        quickSort(desordenado, 0, desordenado.length - 1);
        
        
        System.out.println(Arrays.toString(desordenado));
    }
}
