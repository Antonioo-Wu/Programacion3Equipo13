import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actividad1c {

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

    // MÉTODO PARA CALCULAR LOS RESULTADOS USANDO MAP
    public static Map<Integer, Double> calcularResultadosConMap(List<Factura> facturas) {
        Map<Integer, Double> resultadoMap = new HashMap<>(); // O(1)
        // Un map es un diccionario MAP{num entero, num decimal}
        for (Factura factura : facturas) { // O(m) -> m es la cantidad de facturas
            int idCliente = factura.getIdCliente();
            double importe = factura.getImporte();

            // Actualizamos la suma de importes por cliente
            resultadoMap.put(idCliente, resultadoMap.getOrDefault(idCliente, 0.0) + importe); // O(1) en promedio
            /* Para trabajar con el HashMap utilizamos getOrDefault(idCLiente; 0.0) -> busco el valor asociado 
            con la clave idCliente en el HashMap, si no existe vamos a devovler determinado 0.0*/  
        }

        return resultadoMap; // O(1)
    } // Complejidad total con map : O(m)

    // CLASE MAIN
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 1, 100.0));
        facturas.add(new Factura(2, 1, 200.0));
        facturas.add(new Factura(3, 2, 300.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Cliente A"));
        clientes.add(new Cliente(2, "Cliente B"));

        Map<Integer, Double> resultados = calcularResultadosConMap(facturas);

        // PRINT LINEA POR LINEA
        for (Map.Entry<Integer, Double> resultado : resultados.entrySet()) {
            System.out.println("ID Cliente: " + resultado.getKey() + ", Suma Importes: " + resultado.getValue());
        }
    }
}
