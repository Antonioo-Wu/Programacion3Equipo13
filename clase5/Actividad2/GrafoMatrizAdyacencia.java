package Actividad2;

public class GrafoMatrizAdyacencia 
{
    private int[][] matriz;
    private int numeroVertices;

    public GrafoMatrizAdyacencia(int vertices) 
    {
        this.numeroVertices = vertices;
        this.matriz = new int[vertices][vertices]; 
    }


    public void agregarArista(int origen, int destino) 
    {
        matriz[origen][destino] = 1;
    }

    public void eliminarArista(int origen, int destino) 
    {
        matriz[origen][destino] = 0; 
    }

    public boolean verificarArista(int origen, int destino) 
    {
        return matriz[origen][destino] == 1; 
    }

    public void listarAdyacentes(int vertice) 
    {
        for (int i = 0; i < numeroVertices; i++) 
        {
            if (matriz[vertice][i] == 1) 
                System.out.print(i + " ");
        }
    }

    public int contarGradoSalida(int vertice) 
    {
        int gradoSalida = 0;
        for (int i = 0; i < numeroVertices; i++) 
        {
            if (matriz[vertice][i] == 1) 
                gradoSalida++;
        }
        return gradoSalida;
    }


    public int contarGradoEntrada(int vertice) 
    {
        int gradoEntrada = 0;
        for (int i = 0; i < numeroVertices; i++) 
        {
            if (matriz[i][vertice] == 1) 
                gradoEntrada++;
        }
        return gradoEntrada;
    }

}
