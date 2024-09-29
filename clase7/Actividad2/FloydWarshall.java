package clase7.Actividad2;


public class FloydWarshall {
    final static int INF = 99999;  // Valor grande para representar infinito.

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int graph[][] = { 
                            {0, 8, INF, 5},
                            {INF, 0, -3, INF},
                            {INF, INF, 0, 2},
                            {INF, INF, INF, 0}
                        };

        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

    // Algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        int P[][] = new int[V][V];  // Matriz de reconstrucción de caminos

        // Inicializar matrices de distancia y siguiente nodo
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != INF) {
                    P[i][j] = j; // Si hay un camino directo entre i y j, inicializar con j
                } else {
                    P[i][j] = -1; // Si no hay camino, se inicializa como -1
                }
            }
        }

        // Aplicar algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        P[i][j] = P[i][k];  // Actualizamos el siguiente nodo
                    }
                }
            }
        }

        // Verificamos si existen ciclos negativos
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Existe un ciclo negativo en el grafo");
                return;
            }
        }
        
        // Imprimir la matriz con las rutas
        imprimircaminos(P, V);
    }


    void imprimircaminos(int P[][], int V) {
        System.out.println("Rutas más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && P[i][j] != -1) {
                    System.out.print("Ruta de " + i + " a " + j + ": " + i);
                    imprimirCamino(P, i, j);
                    System.out.println(" -> " + j);
                }
            }
        }
    }

    void imprimirCamino(int P[][], int i, int j) {
        if (P[i][j] == -1) return;
        int nodoIntermedio = P[i][j];
        while (nodoIntermedio != j) {
            System.out.print(" -> " + nodoIntermedio);
            nodoIntermedio = P[nodoIntermedio][j];
        }
    }
}

