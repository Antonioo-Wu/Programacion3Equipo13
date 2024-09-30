package Actividad4;





/*
 * Análisis de Complejidad con Notación Big O:
 * Tiempo:
 * Hay dos bucles anidados: uno que recorre todos los paquetes y otro que recorre 
 * todos los valores de presupuesto. Esto da una complejidad temporal de O(n * P), 
 * donde n es el número de paquetes y P es el presupuesto.
 * 
 */
public class seleccionPaquetesDP  {
    // Función que implementa el algoritmo de programación dinámica para seleccionar los paquetes
    public static int seleccionPaquetes(int[] costos, int[] ganancia, int presupuesto)
    {
        int n = costos.length;  // Número de paquetes
        // Matriz DP donde dp[i][j] representa la ganancia máxima usando los primeros i paquetes con un presupuesto j
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Bucle para llenar la matriz dp[][]
        // i representa el paquete que estamos considerando, y j es el presupuesto disponible
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                // Si el costo del paquete actual (i-1) es menor o igual al presupuesto j
                if (costos[i-1] <= j) {
                    // Decidimos si incluir el paquete o no, eligiendo la opción que da la mayor ganancia
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancia[i - 1]);
                } else {
                    // Si el paquete no cabe en el presupuesto, no lo incluimos y mantenemos la ganancia previa
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Retornamos el valor máximo obtenido con los n paquetes y el presupuesto dado
        return dp[n][presupuesto];
    }

    public static void main(String[] args) 
    {
        // Costos de los paquetes
        int [] costos = {3, 2, 5};
        // Ganancias asociadas a cada paquete
        int [] ganancias = {30, 40, 60};
        // Presupuesto total disponible
        int presupuesto = 8;

        // Llamada a la función y salida del resultado
        System.out.println("El beneficio máximo con el presupuesto " + presupuesto + " es: " 
                           + seleccionPaquetes(costos, ganancias, presupuesto));
    }
}
