package clase10.Actividad3;

/**
 * Actividad 3
 * Diseño de Distribución de Equipos Electrónicos en Oficinas
 * En una oficina de 4x4, se necesita organizar la disposición de computadoras y 
 * impresoras de manera que optimice el uso del espacio y facilite el acceso. 
 * 
 * Las restricciones de diseño son las siguientes: 
 * No puede haber dos computadoras en la misma fila o columna.
 * No puede haber dos impresoras en la misma fila o columna.
 * Debes encontrar todas las combinaciones posibles para colocar 4 computadoras y 4 
 * impresoras en el tablero, respetando las restricciones anteriores.
 * 
 * Objetivo: Implementar un programa en Java que utilice la técnica de backtracking para 
 * encontrar todas las configuraciones posibles de colocación de computadoras e 
 * impresoras en el tablero de 4x4. Tu programa debe imprimir cada configuración válida
 */

 public class Actividad3 {
        // Función para verificar si es seguro colocar un equipo en la posición (fila, columna)
        public static boolean esSeguro(int[][] oficina, int fila, int columna) {
            // Verificamos si ya hay un equipo en la misma fila o columna
            for (int i = 0; i < fila; i++) {
                if (oficina[i][columna] != 0) {
                    return false;
                }
            }
            for (int j = 0; j < columna; j++) {
                if (oficina[fila][j] != 0) {
                    return false;
                }
            }
    
            // Si no hay conflictos, es seguro colocar el equipo
            return true;
        }
    
        // Función recursiva para colocar las computadoras e impresoras usando backtracking
        public static void colocarEquipos(int[][] oficina, int fila, int computadorasRestantes, int impresorasRestantes) {
            // Caso base: si hemos colocado todas las computadoras e impresoras, imprimimos la configuración
            if (computadorasRestantes == 0 && impresorasRestantes == 0) {
                imprimirOficina(oficina);
                return;
            }
    
            // Recorremos cada columna en la fila actual
            for (int columna = 0; columna < oficina.length; columna++) {
                // Intentamos colocar una computadora si quedan computadoras por colocar
                if (computadorasRestantes > 0 && esSeguro(oficina, fila, columna)) {
                    // Colocamos una computadora (representada por 1)
                    oficina[fila][columna] = 1;
    
                    // Llamada recursiva para intentar colocar el siguiente equipo
                    colocarEquipos(oficina, fila + 1, computadorasRestantes - 1, impresorasRestantes);
    
                    // Backtracking: quitamos la computadora
                    oficina[fila][columna] = 0;
                }
    
                // Intentamos colocar una impresora si quedan impresoras por colocar
                if (impresorasRestantes > 0 && esSeguro(oficina, fila, columna)) {
                    // Colocamos una impresora (representada por 2)
                    oficina[fila][columna] = 2;
    
                    // Llamada recursiva para intentar colocar el siguiente equipo
                    colocarEquipos(oficina, fila + 1, computadorasRestantes, impresorasRestantes - 1);
    
                    // Backtracking: quitamos la impresora
                    oficina[fila][columna] = 0;
                }
            }
        }
    
        // Función para imprimir la disposición de las computadoras e impresoras en la oficina
        public static void imprimirOficina(int[][] oficina) {
            for (int[] fila : oficina) {
                for (int valor : fila) {
                    if (valor == 1) {
                        System.out.print("C "); // Computadora
                    } else if (valor == 2) {
                        System.out.print("I "); // Impresora
                    } else {
                        System.out.print(". "); // Espacio vacío
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    
        // Función principal para resolver el problema
        public static void resolverDistribucion() {
            // Creamos una oficina 4x4 vacía
            int[][] oficina = new int[4][4];
    
            // Comenzamos el proceso de backtracking para colocar las computadoras e impresoras
            colocarEquipos(oficina, 0, 4, 4); // Cuatro computadoras y cuatro impresoras
        }
    
        // Método main para ejecutar el programa
        public static void main(String[] args) {
            resolverDistribucion();
        }
    
    
 }