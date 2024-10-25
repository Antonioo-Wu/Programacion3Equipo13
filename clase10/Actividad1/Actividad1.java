package clase10.Actividad1;

/*
 *  Posicionamiento de dos reinas en un tablero de 4x4 usando Backtracking
 * Descripción del Problema: Dado un tablero de ajedrez de tamaño 4x4, debes 
 * encontrar todas las posibles posiciones donde se pueden colocar dos reinas de 
 * tal manera que no se ataquen entre sí. El objetivo es imprimir todas las 
 * configuraciones válidas del tablero. Las dos reinas no deben compartir la misma 
 * fila, columna ni estar en la misma diagonal.
 * 
 *  Para resolver este problema, deberás usar la técnica de Backtracking para 
 * explorar las posibles posiciones de las reinas de manera eficiente. El backtracking 
 * te permitirá descartar las configuraciones inválidas a medida que avances en la 
 * construcción de las soluciones.
 */



public class Actividad1 {

        // Función para verificar si es seguro colocar una reina en la posición (fila, columna)
public static boolean esSeguro(int[][] tablero, int fila, int columna) {
    
    // Verificamos si ya hay una reina en la misma columna
    // Recorremos todas las filas anteriores (de 0 a fila-1) en la columna actual
    for (int i = 0; i < fila; i++) {
        // Si encontramos una reina en la misma columna, devolvemos false
        if (tablero[i][columna] == 1) {
            return false; // No es seguro colocar otra reina
        }
    }

    // Verificamos la diagonal superior izquierda
    // Inicializamos las variables i y j con los valores actuales de fila y columna
    int i = fila, j = columna;
    // Mientras estemos dentro del tablero (i y j no sean negativos)
    while (i >= 0 && j >= 0) {
        // Si encontramos una reina en esta diagonal, devolvemos false
        if (tablero[i][j] == 1) {
            return false; // No es seguro colocar otra reina
        }
        i--; // Movemos una fila hacia arriba
        j--; // Movemos una columna hacia la izquierda
    }

    // Verificamos la diagonal superior derecha
    // Reinicializamos i con fila y j con columna para empezar a revisar esta diagonal
    i = fila;
    j = columna;
    // Mientras estemos dentro del tablero (i no sea negativo y j esté dentro de los límites de las columnas)
    while (i >= 0 && j < tablero.length) {
        // Si encontramos una reina en esta diagonal, devolvemos false
        if (tablero[i][j] == 1) {
            return false; // No es seguro colocar otra reina
        }
        i--; // Movemos una fila hacia arriba
        j++; // Movemos una columna hacia la derecha
    }

    // Si no encontramos ninguna reina que cause conflicto, devolvemos true
    // Es seguro colocar una reina en la posición (fila, columna)
    return true;
}

    
        // Función recursiva para colocar las reinas usando backtracking
        public static void colocarReinas(int[][] tablero, int fila, int reinasRestantes) {
            // Caso base: si hemos colocado las dos reinas, imprimimos el tablero
            if (reinasRestantes == 0) {
                imprimirTablero(tablero);
                return;
            }
    
            // Recorremos cada columna en la fila actual
            for (int columna = 0; columna < tablero.length; columna++) {
                // Si es seguro colocar la reina en (fila, columna)
                if (esSeguro(tablero, fila, columna)) {
                    // Colocamos la reina
                    tablero[fila][columna] = 1;
    
                    // Llamada recursiva para intentar colocar la siguiente reina
                    colocarReinas(tablero, fila + 1, reinasRestantes - 1);
    
                    // Realizamos backtracking y quitamos la reina para probar otra configuración
                    tablero[fila][columna] = 0;
                }
            }
        }
    
        // Función para imprimir el tablero con las reinas colocadas
        public static void imprimirTablero(int[][] tablero) {
            for (int[] fila : tablero) {
                for (int valor : fila) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    
        // Función principal para resolver el problema
        public static void resolverReinas() {
            // Creamos un tablero 4x4 vacío
            int[][] tablero = new int[4][4];
    
            // Comenzamos el proceso de backtracking para colocar las 2 reinas
            colocarReinas(tablero, 0, 2);
        }
    
        // Método main para ejecutar el programa
        public static void main(String[] args) {
            resolverReinas();
        }
    
    
}
