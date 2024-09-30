package progra3.clase5.Actividad3;
import java.util.*;

public class Actividad3 
{
    static class grafo
    {
        private List<List<int[]>> matriz;
        private int numVertices;

        grafo(int n)
        {
            this.numVertices = n;
            matriz = new ArrayList<>(n);
            for (int i = 0; i < n; i++)
            {
                matriz.add(new ArrayList<>());
            }
        }

        public void agregarConexion(int o, int d, int costo)
        {
            matriz.get(o).add(new int[]{d, costo});
            matriz.get(d).add(new int[]{o,costo});
        }

        public int getNumVertices()
        {
            return numVertices;
        }

        public List<List<int[]>> getMatriz()
        {
            return matriz;
        }

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
