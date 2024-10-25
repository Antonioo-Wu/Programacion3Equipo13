package clase10;
/**
 * Actividad 2
 * En el diseño de interiores de oficinas o hogares, necesitamos un programa que 
 * imprima las combinaciones posibles de la ubicación de escritorios y sillas, en una 
 * habitación de 4x4. Las restricciones son: garantizar que ningún elemento esté en 
 * la misma "fila" (por ejemplo, en una misma fila de escritorios) o en la misma 
 * "columna" (por ejemplo, alineación en una pared) para optimizar el uso del 
 * espacio y facilitar la circulación.
 */

 public class Actividad2{
    // Función para verificar si es seguro colocar un escritorio o una silla en la posición (fila, columna)
    public static boolean esSeguro(int[][] habitacion, int fila, int columna) {
        // Verificamos si ya hay un escritorio o silla en la misma fila
        for (int i = 0; i < fila; i++) {
            if (habitacion[i][columna] != 0) {
                return false;
            }
        }
        // Verificamos si ya hay un escritorio o silla en la misma columna
        for (int j = 0; j < columna; j++) {
            if (habitacion[fila][j] != 0) {
                return false;
            }
        }

        // Si no hay conflictos, es seguro colocar el escritorio o silla
        return true;
    }

    // Función recursiva para colocar los escritorios y sillas usando backtracking
    public static void colocarElementos(int[][] habitacion, int fila, int escritoriosRestantes, int sillasRestantes) {
        // Caso base: si hemos colocado todos los escritorios y sillas, imprimimos la habitación
        if (escritoriosRestantes == 0 && sillasRestantes == 0) {
            imprimirHabitacion(habitacion);
            return;
        }

        // Recorremos cada columna en la fila actual
        for (int columna = 0; columna < habitacion.length; columna++) {
            // Intentamos colocar un escritorio si quedan escritorios por colocar
            if (escritoriosRestantes > 0 && esSeguro(habitacion, fila, columna)) {
                // Colocamos un escritorio (representado por 1)
                habitacion[fila][columna] = 1;

                // Llamada recursiva para intentar colocar el siguiente elemento
                colocarElementos(habitacion, fila + 1, escritoriosRestantes - 1, sillasRestantes);

                // Backtracking: quitamos el escritorio
                habitacion[fila][columna] = 0;
            }

            // Intentamos colocar una silla si quedan sillas por colocar
            if (sillasRestantes > 0 && esSeguro(habitacion, fila, columna)) {
                // Colocamos una silla (representada por 2)
                habitacion[fila][columna] = 2;

                // Llamada recursiva para intentar colocar el siguiente elemento
                colocarElementos(habitacion, fila + 1, escritoriosRestantes, sillasRestantes - 1);

                // Backtracking: quitamos la silla
                habitacion[fila][columna] = 0;
            }
        }
    }

    // Función para imprimir la disposición de los escritorios y sillas en la habitación
    public static void imprimirHabitacion(int[][] habitacion) {
        for (int[] fila : habitacion) {
            for (int valor : fila) {
                if (valor == 1) {
                    System.out.print("E "); // Escritorio
                } else if (valor == 2) {
                    System.out.print("S "); // Silla
                } else {
                    System.out.print(". "); // Espacio vacío
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Función principal para resolver el problema
    public static void resolverUbicacion() {
        // Creamos una habitación de 4x4 vacía
        int[][] habitacion = new int[4][4];

        // Comenzamos el proceso de backtracking para colocar los escritorios y sillas
        colocarElementos(habitacion, 0, 2, 2); // Dos escritorios y dos sillas
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
        resolverUbicacion();
    }

 }