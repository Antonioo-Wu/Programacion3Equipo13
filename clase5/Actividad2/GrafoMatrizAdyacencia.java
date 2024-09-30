package Actividad2;

public class GrafoMatrizAdyacencia {
    private int[][] matriz;
    private int numeroVertices;

    public GrafoMatrizAdyacencia(int vertices) {
        this.numeroVertices = vertices; // O(1)
        this.matriz = new int[vertices][vertices]; // O(1)
    } // Complejidad: O(1)
    
    public void agregarArista(int origen, int destino) {
        matriz[origen][destino] = 1; // O(1)
    } // Complejidad: O(1)
    
    public void eliminarArista(int origen, int destino) {
        matriz[origen][destino] = 0; // O(1)
    } // Complejidad: O(1)
    
    public boolean verificarArista(int origen, int destino) {
        // si arista es igual a 1, entonces esta en el grafo
        return matriz[origen][destino] == 1; // O(1)
    } // Complejidad: O(1)
    
    public void listarAdyacentes(int vertice) {
        for (int i = 0; i < numeroVertices; i++) { // O(n)
            if (matriz[vertice][i] == 1) { // O(1)
                System.out.print(i + " "); // O(1)
            }
        }
    } // Complejidad: O(n)
    
    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0; // O(1)
        for (int i = 0; i < numeroVertices; i++) { // O(n)
            if (matriz[vertice][i] == 1) { // O(1)
                gradoSalida++; // O(1)
            }
        }
        return gradoSalida; // O(1)
    } // Complejidad: O(n)
    
    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0; // O(1)
        for (int i = 0; i < numeroVertices; i++) { // O(n)
            if (matriz[i][vertice] == 1) { // O(1)
                gradoEntrada++; // O(1)
            }
        }
        return gradoEntrada; // O(1)
    } // Complejidad: O(n)
    
}