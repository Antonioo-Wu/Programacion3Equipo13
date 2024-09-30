package Actividad4;

/*Análisis de Complejidad con Notación Big O:
 * Tiempo:
 * El número de combinaciones es  2𝑛2 n, donde n es el número de paquetes. Dentro de cada combinación, 
 * se realiza una suma de costos y beneficios para todos los paquetes. Esto da una complejidad temporal 
 * de O(2^n), lo que hace que este enfoque sea ineficiente para grandes valores de n.
 */
public class seleccionPaquetesFB 
{
    // Función que implementa la búsqueda de la mejor combinación de paquetes usando fuerza bruta
    static int mejorCombinacion(int[] costos, int[] beneficios, int presupuesto) 
    {
        int n = costos.length;  // Número de paquetes
        int mejorBeneficio = 0;  // Variable para almacenar el mejor beneficio encontrado

        // Probar todas las combinaciones posibles de paquetes (2^n combinaciones)
        // "1 << n" es equivalente a 2^n, que representa el número total de combinaciones
        for (int i = 0; i < (1 << n); i++) 
        {  
            int costoTotal = 0;  // Variable para almacenar el costo total de la combinación actual
            int beneficioTotal = 0;  // Variable para almacenar el beneficio total de la combinación actual

            // Recorremos cada bit de la combinación actual (i)
            for (int j = 0; j < n; j++) 
            {
                // Si el bit j está activado en i, significa que estamos seleccionando el paquete j
                if ((i & (1 << j)) != 0) 
                {  
                    costoTotal += costos[j];  // Añadimos el costo del paquete j al costo total
                    beneficioTotal += beneficios[j];  // Añadimos el beneficio del paquete j al beneficio total
                }
            }

            // Verificar si el costo total no excede el presupuesto y si el beneficio total es mejor
            if (costoTotal <= presupuesto && beneficioTotal > mejorBeneficio) 
                mejorBeneficio = beneficioTotal;  // Actualizamos el mejor beneficio encontrado
            
        }

        // Retornamos el mejor beneficio encontrado
        return mejorBeneficio;
    }

    public static void main(String[] args) 
    {
        // Costos de los paquetes
        int [] costos = {3, 2, 5};
        // Beneficios asociados a cada paquete
        int [] ganancias = {30, 40, 60};
        // Presupuesto total disponible
        int presupuesto = 8;
        
        // Llamada a la función y salida del resultado
        System.out.println("El beneficio máximo con el presupuesto " + presupuesto + " es: " 
                           + mejorCombinacion(costos, ganancias, presupuesto));
    }
}
