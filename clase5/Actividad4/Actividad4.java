package Actividad4;

public class Actividad4 
{
    public static void main(String[] args) 
    {
        
        DijkstraUndirected.Graph dijkstragrafo = new DijkstraUndirected.Graph(5); // O(n) depende del tamaño de vertices

        dijkstragrafo.addEdge(0, 1, 10);
        dijkstragrafo.addEdge(0, 2, 15); // Carretera entre centro 0 y centro 2 con 15 minutos
        dijkstragrafo.addEdge(1, 3, 12); // Carretera entre centro 1 y centro 3 con 12 minutos
        dijkstragrafo.addEdge(2, 4, 10); // Carretera entre centro 2 y centro 4 con 10 minutos
        dijkstragrafo.addEdge(3, 4, 5);  // Carretera entre centro 3 y centro 4 con 5 minutos
        
        dijkstragrafo.dijkstra(0);

    }
}
