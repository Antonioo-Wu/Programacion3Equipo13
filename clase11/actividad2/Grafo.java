package clase11.actividad2;

import java.util.*;

public class Grafo {
    private int V; // número de vértices
    private LinkedList<Integer>[] adj; // listas de adyacencia para cada vértice

    // Constructor
    public Grafo(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>(); // Inicializar lista de adyacencia para cada vértice
        }
    }


    // Método para agregar una arista
    public void agregarArista(int v, int w) {
        adj[v].add(w); // Añadir w a la lista de adyacencia de v
    }
    // Implementación de BFS
    public void BFS(int inicio) {
        boolean[] visitado = new boolean[V]; // Array de visitados
        LinkedList<Integer> cola = new LinkedList<>(); // Cola para BFS

        visitado[inicio] = true; // Marcar el nodo de inicio como visitado
        cola.add(inicio); // Añadirlo a la cola

        while (!cola.isEmpty()) {
            inicio = cola.poll(); // Extraer el primer nodo de la cola
            System.out.print(inicio + " "); // Procesar el nodo

            // Obtener todos los nodos adyacentes de "inicio"
            for (int n : adj[inicio]) {
                if (!visitado[n]) {
                    visitado[n] = true; // Marcar como visitado
                    cola.add(n); // Añadir a la cola
                }
            }
        }
    }


    // Método main para ejecutar el ejemplo
    public static void main(String[] args) {
        // DFS
        Grafo g1 = new Grafo(9); // Crear un grafo con 6 vértices (0 a 6)

        // Agregar aristas al grafo
        g1.agregarArista(0, 1);
        g1.agregarArista(0, 2);
        g1.agregarArista(1, 4);
        g1.agregarArista(1, 3);
        g1.agregarArista(2, 5);
        g1.agregarArista(3, 6);
        g1.agregarArista(4, 7);
        g1.agregarArista(4, 8);

        System.out.println("");
        System.out.println("Recorrido DFS empezando desde el vértice 0:");

        // Ejecutar DFS desde el vértice 0
        g1.BFS(0);
    }
}