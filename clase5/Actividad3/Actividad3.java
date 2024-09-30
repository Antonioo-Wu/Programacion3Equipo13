package Actividad3;
import java.util.*;

/* CONSIGNA
Diseño de una red de distribución eléctrica
Una empresa de energía necesita conectar varias estaciones eléctricas en una 
región para asegurar que toda la zona esté alimentada de manera eficiente. Las 
estaciones están ubicadas en diferentes ciudades y los costos de instalación de 
las líneas eléctricas entre ellas varían según la distancia y el terreno.
Tareas:
Representar el grafo utilizando una lista de adyacencia.
Aplicar el algoritmo de Prim para determinar el Árbol de Recubrimiento Mínimo.
Mostrar el conjunto de conexiones resultante y calcular el costo total. */

public class Actividad3 {
    static class grafo {
        private List<List<int[]>> matriz;
        private int numVertices;
    
        grafo(int n) {
            this.numVertices = n; // O(1)
            matriz = new ArrayList<>(n); // O(n)
            for (int i = 0; i < n; i++) {  // 1n+ 2n +2n = O
                matriz.add(new ArrayList<>()); // O(1) por cada iteración, total O(n)
            }
        } // Complejidad : O(n)
    
        public void agregarConexion(int o, int d, int costo) {
            matriz.get(o).add(new int[]{d, costo}); // O(1)
            matriz.get(d).add(new int[]{o, costo}); // O(1)
        } // Complejidad : O(1)
    
        public int getNumVertices() {
            return numVertices; // O(1)
        } // Complejidad : O(1)
    
        public List<List<int[]>> getMatriz() {
            return matriz; // O(1)
        } // Complejidad : O(1)
    }
    
    public static void main(String[] args) 
    {
        grafo grafo = new grafo(5);
        grafo.agregarConexion(0, 1, 10);
        grafo.agregarConexion(0, 2, 5);
        grafo.agregarConexion(0, 3, 20);
        grafo.agregarConexion(1, 2, 30);
        grafo.agregarConexion(1, 3, 15); 
        grafo.agregarConexion(3, 4, 10); 

      PrimAlgorithm.primMST(grafo.getNumVertices(), grafo.getMatriz());
        
    }
    
}
