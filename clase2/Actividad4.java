import java.util.*;

public class Actividad4 {

    public static void merge(int[] arreglo, int[] izq, int[] der) {
        int i = 0;
        int j = 0;
        int k = 0;

        // Mezclar los elementos en orden
        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {
                arreglo[k++] = izq[i++];
            } else {
                arreglo[k++] = der[j++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (i < izq.length) {
            arreglo[k++] = izq[i++];
        }

        // Copiar los elementos restantes de la mitad derecha
        while (j < der.length) {
            arreglo[k++] = der[j++];
        }
    }

/*
 * El método merge toma dos subarreglos ordenados (izq y der) y los combina en un solo
 * arreglo ordenado. Utiliza tres índices: i para recorrer izq, j para recorrer der,
 * y k para colocar los elementos en el arreglo original.
 */

    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si tiene 0 o 1 elemento, ya está ordenado
        }
        int medio = arreglo.length / 2;

        int[] izq = new int[medio];
        int[] der = new int[arreglo.length - medio];

        // Copiar los elementos a los subarreglos izq y der
        for (int i = 0; i < medio; i++) {
            izq[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            der[i - medio] = arreglo[i];
        }

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izq);
        mergeSort(der);

        // Mezclar las mitades ordenadas
        merge(arreglo, izq, der);
        }

    public static void main(String[] args) {
        int[] desordenado = {354, 6757, 213, 80, 34, 87};
        mergeSort(desordenado);
        System.out.println(Arrays.toString(desordenado));
    }    
}
/*
 * El método mergeSort es recursivo. Divide el arreglo en dos mitades, llama a sí mismo
 * para ordenar cada mitad, y luego usa el método merge para combinar las mitades ordenadas.
 */
