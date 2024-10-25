package clase11.actividad3;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(0,"Almacen 0");
        almacen.agregarDestino(1);
        almacen.agregarDestino(2);
        almacen.agregarDestino(4);
        Almacen almacen1 = new Almacen(1,"Almacen 1");
        almacen1.agregarDestino(3);
        almacen1.agregarDestino(5);
        CentroDistribucion centroDistribucion
            = new CentroDistribucion();
        centroDistribucion.agregarAlmacen(almacen);
        centroDistribucion.agregarAlmacen(almacen1);
        // System.out.println(centroDistribucion);
        centroDistribucion.DFS(0);
        centroDistribucion.BFS(0);
    }
}