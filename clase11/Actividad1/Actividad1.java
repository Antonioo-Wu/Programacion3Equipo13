package clase11.Actividad1;

public class Actividad1 {
    // Función que realiza la búsqueda en profundidad (DFS) en un grafo
    public static void DFS(int grafo[][], int nodoInicial, boolean[] visitado) {
        // Marcamos el nodo actual como visitado
        visitado[nodoInicial] = true;
        
        // Imprimimos el nodo que estamos visitando
        System.out.print(nodoInicial + " ");
        
        // Recorremos todos los nodos adyacentes del nodo actual
        for (int i = 0; i < grafo[nodoInicial].length; i++) {
            // Si el nodo adyacente no ha sido visitado, realizamos DFS recursivo
            if (grafo[nodoInicial][i] == 1 && !visitado[i]) {
                DFS(grafo, i, visitado);
            }
        }
    }
    
    public static void main(String[] args) {
        // Representación del grafo como una matriz de adyacencia
        int[][] grafo = {
            {0, 1, 1, 0, 0, 0, 0, 0, 0},  // Nodo 0
            {1, 0, 0, 0, 1, 0, 0, 0, 0},  // Nodo 1
            {1, 0, 0, 1, 0, 1, 0, 0, 0},  // Nodo 2
            {0, 0, 1, 0, 0, 0, 1, 0, 0},  // Nodo 3
            {0, 1, 0, 0, 0, 0, 0, 1, 0},  // Nodo 4
            {0, 0, 1, 0, 0, 0, 0, 0, 0},  // Nodo 5
            {0, 0, 0, 1, 0, 0, 0, 0, 0},  // Nodo 6
            {0, 0, 0, 0, 1, 0, 0, 0, 1},  // Nodo 7
            {0, 0, 0, 0, 0, 0, 0, 1, 0}   // Nodo 8
        };

        // Crear una lista de nodos visitados
        boolean[] visitado = new boolean[9];
        
        // Llamamos a la función DFS para iniciar el recorrido desde el nodo 0
        System.out.print("Recorrido DFS desde el nodo 0: ");
        DFS(grafo, 0, visitado);

    }
}