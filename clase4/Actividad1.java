
package Progra3.clase4;

import java.util.Arrays;

/*
 * ### Actividad 1: Cambio de Moneda

Implementar una función que, siguiendo la técnica de diseño greedy, determine si es posible entregar un cambio exacto utilizando una lista de monedas disponible.

Realizar pseudocódigo e implementación en java.

Indicar la complejidad algorítmica
 */
public class Actividad1 {
    public static boolean cambioMoneda(int[] monedas, int cambio){
        // Ordeno las monedas de mayor a menor
        Arrays.sort(monedas); // O(n log n) !!!!!
        for(int i = monedas.length-1; i >= 0; i--){  // 1 + 2n + 2n = O(n)
            // Restamos tantas monedas como podamos
            while(cambio >= monedas[i]){ // En el peor de los casos, O(cambio / monedas[i]
                // mientras que sea mas grande y/o igual que las monedas
                cambio -= monedas[i];
            }
        }
        // Si el cambio es 0, se puede entregar el cambio exacto
        return cambio == 0; // O(1)
    }
    /*
     * Complejidad Total: La complejidad total del algoritmo es la suma de las complejidades de cada parte:
    O(n log n) (ordenamiento)
    O(n * (cambio / min(monedas))) (bucle anidado)
    Por lo tanto, la complejidad total es O(n log n + n * (cambio / min(monedas))).
     */
    public static void main(String[] args) {
        int[] monedas = {1,2,5,10,25};
        int cambio = 6904;

        // como el método es true or false
        if(cambioMoneda(monedas,cambio)){
            System.out.println("Es posible entregarle el cambio exacto al monto ingresado.");
        }else{
            System.out.println("No es posible entregarle el cambio exacto al monto ingresado.");
        }
    }
}