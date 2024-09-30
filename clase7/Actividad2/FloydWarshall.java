
package clase7.Actividad2;
/*Análisis de Complejidad con Notación Big O:
 * Tiempo:
 * El algoritmo de Floyd-Warshall tiene tres bucles 
 * anidados sobre el número de vértices V. Por lo tanto, 
 * su complejidad temporal es O(n³).
 * 
 * Esto lo hace adecuado para grafos con un número moderado 
 * de vértices, pero no es eficiente para grafos muy grandes.
 *
 * Espacio:
 * Se necesitan dos matrices de tamaño V x V (dist[][] y P[][]),
 * lo que lleva a una complejidad espacial de O(n²)
 * 
 */
public class FloydWarshall {
    final static int INF = 99999;  // Valor grande para representar infinito.

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        
        // Grafo representado como una matriz de adyacencia
        int graph[][] = { 
                            {0, 8, INF, 5},    // Nodo 0 conectado a nodo 1 (8) y nodo 3 (5)
                            {INF, 0, -3, INF}, // Nodo 1 conectado a nodo 2 con peso negativo (-3)
                            {INF, INF, 0, 2},  // Nodo 2 conectado a nodo 3 (2)
                            {INF, INF, INF, 0} // Nodo 3 no tiene conexiones directas
                        };

        int V = graph.length;  // Número de vértices
        fw.floydWarshall(graph, V);  // Llamada al algoritmo de Floyd-Warshall
    }

    // Algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];  // Matriz para almacenar las distancias mínimas entre todos los pares de nodos
        int P[][] = new int[V][V];     // Matriz para almacenar los caminos intermedios (para reconstrucción de caminos)

        // Inicializamos las matrices de distancia y de reconstrucción de caminos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];  // Copiamos la matriz de adyacencia
                // Si hay un camino directo entre i y j, inicializamos P[i][j] con j
                if (i != j && graph[i][j] != INF) {
                    P[i][j] = j;
                } else {
                    P[i][j] = -1;  // Si no hay camino, inicializamos con -1
                }
            }
        } // Complejidad O(n³) ---> :(


        // Aplicamos el algoritmo de Floyd-Warshall
        // Para cada nodo intermedio 'k'
        for (int k = 0; k < V; k++) {
            // Para cada par de nodos (i, j)
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Si la distancia pasando por el nodo 'k' es menor que la actual, la actualizamos
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];  // Actualizamos la distancia mínima
                        P[i][j] = P[i][k];  // Actualizamos el siguiente nodo en el camino
                    }
                }
            }
        }

        // Después de ejecutar el algoritmo, verificamos si hay ciclos negativos
        // Si dist[i][i] es negativo, significa que hay un ciclo negativo
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Existe un ciclo negativo en el grafo");
                return;
            }
        }
        
        // Imprimimos los caminos más cortos entre cada par de vértices
        imprimircaminos(P, V);
    }

    // Función para imprimir los caminos más cortos entre los nodos
    void imprimircaminos(int P[][], int V) {
        System.out.println("Rutas más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // Si hay un camino entre i y j (es decir, P[i][j] != -1)
                if (i != j && P[i][j] != -1) {
                    System.out.print("Ruta de " + i + " a " + j + ": " + i);
                    imprimirCamino(P, i, j);  // Imprimimos el camino intermedio
                    System.out.println(" -> " + j);
                }
            }
        }
    }

    // Función auxiliar para imprimir el camino entre dos nodos
    void imprimirCamino(int P[][], int i, int j) {
        if (P[i][j] == -1) return;  // Si no hay camino, retornamos
        int nodoIntermedio = P[i][j];  // Recuperamos el nodo intermedio entre i y j
        while (nodoIntermedio != j) {  // Imprimimos todos los nodos intermedios
            System.out.print(" -> " + nodoIntermedio);
            nodoIntermedio = P[nodoIntermedio][j];  // Actualizamos el nodo intermedio
        }
    }
}
