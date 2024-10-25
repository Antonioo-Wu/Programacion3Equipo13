package clase12.Actividad2;

import java.util.*;

class Node {
    String name;
    int cost;

    public Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class Actividad2 {
    private final Map<String, List<Node>> graph = new HashMap<>();

    // Agregar conexiones al grafo
    public void añadirVuelo(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Node(to, cost));
    }

    // Método para realizar la búsqueda UCS
    public int uniformCostSearch(String start, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        priorityQueue.add(new Node(start, 0));
        Set<String> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            // Si alcanzamos el nodo objetivo, retornamos el costo
            if (current.name.equals(goal)) {
                return current.cost;
            }

            // Si ya hemos visitado este nodo, lo ignoramos
            if (visited.contains(current.name)) continue;
            visited.add(current.name);

            // Explorar vecinos
            for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
                if (!visited.contains(neighbor.name)) {
                    priorityQueue.add(new Node(neighbor.name, current.cost + neighbor.cost));
                }
            }
        }

        return -1; // Retorna -1 si no se encuentra un camino
    }

    public static void main(String[] args) {
        Actividad2 sistemaSeleccionViajes = new Actividad2();

        // Agregar conexiones
        sistemaSeleccionViajes.añadirVuelo("A", "B", 350);
        sistemaSeleccionViajes.añadirVuelo("A", "C", 200);
        sistemaSeleccionViajes.añadirVuelo("B", "C", 120);
        sistemaSeleccionViajes.añadirVuelo("B", "D", 450);
        sistemaSeleccionViajes.añadirVuelo("C", "E", 700);
        sistemaSeleccionViajes.añadirVuelo("D", "E", 525);

        // Ejecutar UCS
        String start = "A";
        String destination = "E";
        int totalCost = sistemaSeleccionViajes.uniformCostSearch(start, destination);
        
        if (totalCost != -1) {
            System.out.println("El costo mínimo desde " + start + " hasta " + destination + " es: " + totalCost);
        } else {
            System.out.println("No se encontró un camino desde " + start + " hasta " + destination);
        }
    }
}