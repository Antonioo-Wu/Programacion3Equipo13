package Actividad4;
import java.util.*;
/*
 * Complejidad con Notacion Big O:
 * La complejidad total del algoritmo Dijkstra 
 * utilizando una lista de adyacencia y una cola de prioridad es O((V + E) log V)1
 */

public class Dijkstra {
    static class Edge {
        int target;
        int weight;
        
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices); // O(V)
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>()); // O(1) por cada iteración, total O(V)
            }
        }

        void addEdge(int source, int target, int weight) {
            adjList.get(source).add(new Edge(target, weight)); // O(1)
        }

        void dijkstra(int startVertex) {
            int[] distances = new int[vertices]; // O(V)
            Arrays.fill(distances, Integer.MAX_VALUE); // O(V)
            distances[startVertex] = 0; // O(1)

            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.weight)); // O(V)
            pq.add(new Edge(startVertex, 0)); // O(log V)

            boolean[] visited = new boolean[vertices]; // O(V)

            while (!pq.isEmpty()) {
                int u = pq.poll().target; // O(log V)

                if (visited[u]) continue; // O(1)
                visited[u] = true; // O(1)

                for (Edge edge : adjList.get(u)) {
                    int v = edge.target;
                    int weight = edge.weight;

                    if (!visited[v] && distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight; // O(1)
                        pq.add(new Edge(v, distances[v])); // O(log V)
                    }
                }
            }

            printSolution(distances, startVertex); // O(V)
        }

        void printSolution(int[] distances, int startVertex) {
            System.out.println("Distancia desde el vértice " + startVertex); // O(1)
            for (int i = 0; i < vertices; i++) {
                System.out.println("Hasta " + i + " es " + distances[i]); // O(V)
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        
        // Añadir aristas al grafo
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 1);
        graph.addEdge(3, 5, 2);

        graph.dijkstra(0);  // Ejecutar Dijkstra desde el vértice 0
    }
    
}
