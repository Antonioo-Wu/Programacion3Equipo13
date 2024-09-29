import java.util.HashMap;
import java.util.Map;

/*
 * ### Actividad 3

Objetivo: Aplicar la técnica de Divide y Vencerás en una lista de clientes con id, nombre y scoring, buscando los dos clientes con los scoring máximos.

Tareas:

- Resolver mediante pseudocódigo
- Realizar el análisis de recurrencia mediante método inductivo (sin utilizar fórmulas matemáticas) para indicar la complejidad algorítmica.
- Implementar en java
 */
public class Actividad3 {
    class Cliente{
        int idCliente;
        String nombre;
        int scoring;

        public Cliente(int idCliente, String nombre,int scoring){
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.scoring = scoring;
        }
        @Override
        public String toString() {
            return nombre + " (ID: " + idCliente + ", Scoring: " + scoring + ")";
        }
        
    }

    public static Cliente[] encontarDosMayores(Map<Integer, Cliente> clientes, int inicio, int fin){
        if(fin - inicio == 1){ // caso base : si solo quedan 2 clientes
            Cliente c1 = clientes.get(inicio); // O(1)
            Cliente c2 = clientes.get(fin); // O(1)

            if(c1.scoring > c2.scoring){ // O(1)
                return new Cliente[]{c1,c2}; // O(1)
            }else{
                return new Cliente[]{c2,c1}; // O(1)
            }

        }

        int mitad = (inicio + fin) / 2; // O(1)

        Cliente[] izq = encontarDosMayores(clientes, inicio, mitad); // T(n/2)
        Cliente[] der = encontarDosMayores(clientes, mitad+1, fin); // T(n/2)

        Cliente mayorGlobal = izq[0].scoring > der[0].scoring ? izq[0] : der[0];
        Cliente segundoMayorGlobal;

        if(mayorGlobal == izq[0]){ //O(1)
            segundoMayorGlobal = izq[1].scoring > der[0].scoring ? izq[1] : der[0]; // O(1)
        }else{
            segundoMayorGlobal = der[1].scoring > izq[0].scoring ? der[1] : izq[0]; // O(1)
        }

        return new Cliente[]{mayorGlobal,segundoMayorGlobal}; // O(1)
    }

    public static void main(String[] args) {
        // Ejercicio con HashMap
        Map<Integer, Cliente> clientes = new HashMap<>();
        //ACÁ TENGO UN ERROR PERO NO SE COMO RESOLVERLO :(
        /*
        clientes.put(1, new Cliente(1, "Cliente A", 85));
        clientes.put(2, new Cliente(2, "Cliente B", 70));
        clientes.put(3, new Cliente(3, "Cliente C", 95));
        clientes.put(4, new Cliente(4, "Cliente D", 60));
        clientes.put(5, new Cliente(5, "Cliente E", 90));
        */
        Cliente[] result = encontarDosMayores(clientes, 0, clientes.size() - 1); // O(n)

        System.out.println("Los dos clientes con los mayores scorings son: ");
        System.out.println("Mayor scoring: " + result[0]);
        System.out.println("Segundo mayor scoring: " + result[1]);
    }
}

/*
 * El algoritmo tiene una complejidad de O(n). 
 * Esto se debe a que en cada nivel de la recursión, 
 * la combinación de resultados toma un tiempo constante O(1), 
 * pero el número de niveles de recursión es proporcional al 
 * número de divisiones posibles, lo que lleva a una complejidad 
 * final lineal O(n).

Si bien usamos HashMap, este no afecta la complejidad general del 
problema en este caso específico, porque el acceso y manipulación 
en el HashMap sigue siendo O(1).
 */