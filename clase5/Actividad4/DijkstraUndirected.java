package Actividad4;
import java.util.*;

public class DijkstraUndirected 
{
    // Clase que representa una arista en el grafo
    static class Edge {
        int target;  // El nodo al que apunta la arista
        int weight;  // Peso de la arista

        // Constructor de Edge
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Clase que representa el grafo
    static class Graph {
        int vertices;  // Número de vértices en el grafo
        List<List<Edge>> adjList;  // Lista de adyacencia para almacenar el grafo

        // Constructor de Graph
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());  // Inicializamos la lista de adyacencia
            }
        }

        // Método para agregar aristas para grafos no dirigidos (bidireccionales)
        // Complejidad: O(1) por cada arista añadida
        void addEdge(int source, int target, int weight) {
            adjList.get(source).add(new Edge(target, weight));  // Añadimos la arista de source a target
            adjList.get(target).add(new Edge(source, weight));  // Añadimos la arista inversa (bidireccional)
        }

        // Método que implementa el algoritmo de Dijkstra para encontrar las distancias más cortas
        // Complejidad: O((V + E) log V), donde V es el número de vértices y E el número de aristas
        void dijkstra(int startVertex) {
            // Array para almacenar las distancias mínimas desde el vértice de inicio
            int[] distances = new int[vertices];
            // Inicializamos todas las distancias como "infinito" excepto el vértice de inicio
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;

            // Cola de prioridad que almacena los vértices según su distancia mínima conocida
            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.weight));
            pq.add(new Edge(startVertex, 0));  // Añadimos el vértice de inicio a la cola de prioridad

            // Array para marcar los vértices que ya han sido procesados
            boolean[] visited = new boolean[vertices];

            // Mientras haya vértices en la cola de prioridad
            while (!pq.isEmpty()) {
                // Extraemos el vértice con la distancia mínima de la cola
                int u = pq.poll().target;

                // Si el vértice ya fue visitado, lo saltamos
                if (visited[u]) continue;
                visited[u] = true;  // Marcamos el vértice como procesado

                // Recorremos las aristas adyacentes al vértice u
                for (Edge edge : adjList.get(u)) {
                    int v = edge.target;  // Nodo destino de la arista
                    int weight = edge.weight;  // Peso de la arista

                    // Si encontramos una ruta más corta hacia el vértice v
                    if (!visited[v] && distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight;  // Actualizamos la distancia mínima a v
                        pq.add(new Edge(v, distances[v]));  // Añadimos v a la cola de prioridad
                    }
                }
            }

            // Imprimimos las distancias desde el vértice de inicio
            printSolution(distances, startVertex);
        }

        // Método para imprimir las distancias mínimas desde el vértice de inicio
        // Complejidad: O(V), ya que se recorre el array de distancias
        void printSolution(int[] distances, int startVertex) {
            System.out.println("Distancia desde el vértice " + startVertex);
            for (int i = 0; i < vertices; i++) {
                System.out.println("Hasta " + i + " es " + distances[i]);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        // Añadir aristas al grafo no dirigido
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 1);
        graph.addEdge(3, 5, 2);
        graph.addEdge(2, 5, 1);

        graph.dijkstra(0);  // Ejecutar Dijkstra desde el vértice 0
    }
    
}
