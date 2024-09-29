<<<<<<< HEAD


public class Actividad2 {
   
=======
public class Actividad2 
{
    
>>>>>>> 360bee42724c126ad6f607b80a7a63e238b4e849
    // Método para realizar la búsqueda binaria
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0; // comienzo
        int derecha = arreglo.length - 1;  // fin 

        while (izquierda <= derecha) {
            // IZQ + (DER - IZQ) / 2 ---> TOTAL 10  : 1 + {(9-1) / 2} = 1 + ( 8 / 2)  = 1 + 4 = 5
            int medio = izquierda + (derecha - izquierda) / 2;

            // Verificar si el objetivo está en el medio
            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } 
            // Si el objetivo es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }

        // Si no se encuentra el objetivo, retorna -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13};
        int objetivo = 7;
        int resultado = busquedaBinaria(arreglo, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }
    }
}
    

