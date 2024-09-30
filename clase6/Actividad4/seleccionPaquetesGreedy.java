package Actividad4;

import java.util.*;
/*
 * Análisis de Complejidad:
 * Tiempo:
 *  La operación de ordenación tiene una complejidad de O(n log n), 
 * donde n es el número de paquetes.
 * El bucle que selecciona los paquetes tiene una complejidad de O(n).
 * Por lo tanto, la complejidad total del algoritmo es O(n log n).
 * 
 */
public class seleccionPaquetesGreedy 
{
    // Clase para representar un paquete con costo y ganancia
    static class paquete 
    {
        int costo;
        int ganancia;

        // Constructor de la clase paquete
        public paquete(int costo, int ganancia) 
        {
            this.costo = costo;
            this.ganancia = ganancia;
        }

        // Método para imprimir el paquete (opcional, para debugging)
        @Override
        public String toString() 
        {
            return "costo: " + costo + " ganancia: " + ganancia;
        }
    }
    
    // Función que implementa el algoritmo greedy para seleccionar los paquetes
    public static int optimizarPresupuesto(int[] costos, int[] ganancias, int presupuesto) 
    {
        // Crear una lista de paquetes (cada paquete tiene costo y ganancia)
        paquete[] paquetes = new paquete[costos.length];
        
        // Inicializamos los paquetes con los costos y ganancias dados
        for (int i = 0; i < costos.length; i++) 
        {
            paquetes[i] = new paquete(costos[i], ganancias[i]);
        }

        // Ordenamos los paquetes por ganancia de mayor a menor
        Arrays.sort(paquetes, (a, b) -> Double.compare(b.ganancia, a.ganancia));

        int gananciaTotal = 0;  // Variable para almacenar la ganancia total
        int costoTotal = 0;     // Variable para almacenar el costo total

        // Seleccionar paquetes de mayor ganancia mientras no se exceda el presupuesto
        for (paquete p : paquetes) 
        {
            // Si al añadir este paquete no excedemos el presupuesto, lo seleccionamos
            if (costoTotal + p.costo <= presupuesto) 
            {
                costoTotal += p.costo;       // Actualizamos el costo total
                gananciaTotal += p.ganancia; // Actualizamos la ganancia total
            }
        }

        // Retornamos la ganancia total obtenida
        return gananciaTotal;
    }

    public static void main(String[] args) 
    {
        // Costos de los paquetes
        int[] costos = {10, 15, 20, 25};
        // Ganancias asociadas a cada paquete
        int[] ganancias = {100, 200, 150, 300};
        // Presupuesto total disponible
        int presupuesto = 40;

        // Llamada a la función optimizarPresupuesto y salida del resultado
        int gananciaMaxima = optimizarPresupuesto(costos, ganancias, presupuesto);

        System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + gananciaMaxima);
    }
}

