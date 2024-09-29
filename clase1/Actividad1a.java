public class Actividad1a {
    /*
 * Dada esta matriz: int[][] mat = {{4,5,6},{7,8,9},{5,6,7}};
Realizar un programa en java para calcular el promedio.
Para los cálculos, asumir que la matriz es cuadrada
Realizar el conteo de instrucciones.
Calcular la complejidad asintótica
 */
public class Actividad1a {
    public static int MaximoArray(int[] arr){
        int max = arr[0]; // O(1) - inicializo la variable con el primer elem del arreglo

        for(int i = 1; i < arr.length; i++){ // O(n) - comienzo mi for desde la segunda pos del arreglo
            if(arr[i] > max){ // O(1) - si el elemento es mayor que 'max', actualizamos 'max'
                max = arr[i]; // O(1) - actualización de 'max'
            }
        }
        return max; // O(1) - retorno del valor máximo
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; // O(1) - inicialización del arreglo
        int max = MaximoArray(arr); // O(n) - llamada al método MaximoArray
        System.out.println("El máximo es : " + max); // O(1) - impresión del resultado
    }
}

}
