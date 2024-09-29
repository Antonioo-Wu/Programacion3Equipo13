package Clase7.Actividad3;

import java.util.Scanner;

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

        // Pedir vértices de origen y destino

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el vértice de origen (0 a " + (V-1) + "): ");
        int origen = scanner.nextInt();
        System.out.println("Ingrese el vértice de origen (0 a " + (V-1) + "): ");
        int destino = scanner.nextInt();

        // Imprimir el camino más corto entre el origen y el destino
        System.out.println("El camino más corto desde " + origen + " hasta " + destino + " es: ");
        fw.imprimirCamino(origen, destino);
        scanner.close();
    }

    int dist[][];
    int P[][];

    // Algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        dist = new int[V][V];
        P= new int[V][V];  // Matriz de reconstrucción de caminos

        // Inicializar matrices de distancia y siguiente nodo
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != INF) {
                    P[i][j] = i; // Si hay un camino directo entre i y j, inicializar con j
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
        
    }

    // Función para imprimir el camino más corto usando la matriz P
    void imprimirCamino(int origen, int destino) {
        if (P[origen][destino] == -1) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
            return;
        }
        imprimirCaminoRecursivo(origen, destino);
        System.out.println(destino); // Finalmente imprimimos el destino
    }

    // Método recursivo para reconstruir el camino desde origen hasta destino
    void imprimirCaminoRecursivo(int origen, int destino) {
        if (P[origen][destino] == origen) {
            System.out.print(origen + " -> ");
            return;
        }
        imprimirCaminoRecursivo(origen, P[origen][destino]);
        System.out.print(P[origen][destino] + " -> ");
    }
}

