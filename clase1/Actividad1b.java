package Progra3.clase1;

import java.util.ArrayList;
import java.util.List;

public class Actividad1b {

    // CLASE FACTURA
    static class Factura {
        @SuppressWarnings("unused")
        private int idFactura;
        private int idCliente;
        private double importe;

        Factura(int idFactura, int idCliente, double importe) {
            this.idFactura = idFactura;
            this.idCliente = idCliente;
            this.importe = importe;
        }

        public int getIdCliente() {
            return idCliente;
        }

        public double getImporte() {
            return importe;
        }
    }

    // CLASE CLIENTE
    static class Cliente {
        private int idCliente;
        @SuppressWarnings("unused")
        private String nombre;

        Cliente(int idCliente, String nombre) {
            this.idCliente = idCliente;
            this.nombre = nombre;
        }

        public int getIdCliente() {
            return idCliente;
        }
    }

    // CLASE RESULTADO
    static class Resultado {
        private int idCliente;
        private double sumaImportes;

        Resultado(int idCliente, double sumaImportes) {
            this.idCliente = idCliente;
            this.sumaImportes = sumaImportes;
        }

        public int getIdCliente() {
            return idCliente;
        }

        public double getSumaImportes() {
            return sumaImportes;
        }
    }

    // MÉTODO PARA CALCULAR LOS RESULTADOS SIN MAP
    public static List<Resultado> calcularResultados(List<Factura> facturas, List<Cliente> clientes) {
        List<Resultado> resultados = new ArrayList<>(); // O(1)

        for (Cliente cliente : clientes) { // O(n) -> n es la cantidad de clientes
            double suma = 0;
            for (Factura factura : facturas) { // O(m) -> m es la cantidad de facturas
                if (factura.getIdCliente() == cliente.getIdCliente()) { // O(1)
                    suma += factura.getImporte(); // O(1)
                }
            }
            resultados.add(new Resultado(cliente.getIdCliente(), suma)); // O(1)
            
        }
        return resultados; // O(1)
    } // Complejidad total sin map : O(n * m)

    // CLASE MAIN
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 1, 100.0));
        facturas.add(new Factura(2, 1, 200.0));
        facturas.add(new Factura(3, 2, 300.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Cliente A"));
        clientes.add(new Cliente(2, "Cliente B"));

        List<Resultado> resultados = calcularResultados(facturas, clientes);

        // PRINT LINEA POR LINEA
        for (Resultado resultado : resultados) {
            System.out.println("ID Cliente: " + resultado.getIdCliente() + ", Suma Importes: " + resultado.getSumaImportes());
        }
    }
}
