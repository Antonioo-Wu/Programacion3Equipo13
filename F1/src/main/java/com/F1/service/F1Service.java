package com.F1.service;

import com.F1.model.Corredor;
import com.F1.model.Equipo;
import com.F1.model.NodoEquipo;
import com.F1.repository.CorredorRepository;
import com.F1.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class F1Service {
    
    @Autowired
    private EquipoRepository equipoRepository;
    
    @Autowired
    private CorredorRepository corredorRepository;
    
    public Equipo saveEquipo(Equipo equipo, Long rivalId) {
        if (equipo.getNombre() == null || equipo.getNombre().trim().isEmpty()) {
            throw new RuntimeException("El nombre del equipo es requerido");
        }

        // Verificar si el rival existe
        Equipo rival = equipoRepository.findById(rivalId)
            .orElseThrow(() -> new RuntimeException("Rival no encontrado"));

        // Asignar el rival al equipo
        equipo.getRivales().add(rival);

        return equipoRepository.save(equipo);
    }
    
    public Corredor saveCorredor(Corredor corredor) {
        if (corredor.getNombre() == null || corredor.getNombre().trim().isEmpty()) {
            throw new RuntimeException("El nombre del corredor es requerido");
        }
        if (corredor.getPais() == null || corredor.getPais().trim().isEmpty()) {
            throw new RuntimeException("El país del corredor es requerido");
        }
        if (corredor.getEquipo() == null || corredor.getEquipo().getId() == null) {
            throw new RuntimeException("El equipo es requerido");
        }
        
        // Verificar que el equipo existe
        Equipo equipo = equipoRepository.findById(corredor.getEquipo().getId())
            .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        
        corredor.setEquipo(equipo);
        return corredorRepository.save(corredor);
    }
    
    // DFS
    public List<String> dfsRecorrido(Long equipoId) {
        Equipo inicio = equipoRepository.findById(equipoId)
            .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        List<Equipo> visitados = new ArrayList<>();
        dfsHelper(inicio, visitados);
        return visitados.stream()
            .map(Equipo::toString)
            .collect(Collectors.toList());
    }
    
    private void dfsHelper(Equipo equipo, List<Equipo> visitados) {
        visitados.add(equipo);
        for (Equipo rival : equipo.getRivales()) {
            if (!visitados.contains(rival)) {
                dfsHelper(rival, visitados);
            }
        }
    }
    
    // BFS
    public List<String> bfsRecorrido(Long equipoId) {
        Equipo inicio = equipoRepository.findById(equipoId)
            .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        List<Equipo> visitados = new ArrayList<>();
        Queue<Equipo> cola = new LinkedList<>();
        
        visitados.add(inicio);
        cola.add(inicio);
        
        while (!cola.isEmpty()) {
            Equipo actual = cola.poll();
            for (Equipo rival : actual.getRivales()) {
                if (!visitados.contains(rival)) {
                    visitados.add(rival);
                    cola.add(rival);
                }
            }
        }
        return visitados.stream()
            .map(Equipo::toString)
            .collect(Collectors.toList());
    }
    
    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAllWithRivales();
    }

    //backtracking
    public List<String> backtrackingRecorrido(Long equipoId) {
        Equipo inicio = equipoRepository.findById(equipoId)
            .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        
        List<String> recorrido = new ArrayList<>();
        Set<Equipo> visitados = new HashSet<>();
        
        backtrackingHelper(inicio, visitados, recorrido);
        
        return recorrido;
    }

    private void backtrackingHelper(Equipo actual, Set<Equipo> visitados, List<String> recorrido) {
        visitados.add(actual);
        recorrido.add(actual.getNombre());
        
        for (Equipo rival : actual.getRivales()) {
            if (!visitados.contains(rival)) {
                backtrackingHelper(rival, visitados, recorrido);
                // Backtrack: agregamos una marca para mostrar cuando retrocedemos
                recorrido.add("Retrocediendo a " + actual.getNombre());
            }
        }
    }

    public List<String> podaAlfaBetaRecorrido(Long equipoId) {
        Equipo inicio = equipoRepository.findById(equipoId)
            .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        
        NodoEquipo nodoInicio = new NodoEquipo(inicio);
        List<String> recorrido = new ArrayList<>();
        
        alfaBeta(nodoInicio, 3, Integer.MIN_VALUE, Integer.MAX_VALUE, true, recorrido);
        
        return recorrido;
    }

    private int alfaBeta(NodoEquipo nodo, int profundidad, int alfa, int beta, boolean esMaximizador, List<String> recorrido) {
        if (nodo.esNodoTerminal() || profundidad == 0) {
            recorrido.add(nodo.getEquipo().getNombre() + " (Valor: " + nodo.obtenerValor() + ")");
            return nodo.obtenerValor();
        }

        if (esMaximizador) {
            int mejorValor = Integer.MIN_VALUE;
            for (NodoEquipo hijo : nodo.obtenerHijos()) {
                recorrido.add(nodo.getEquipo().getNombre() + " -> " + hijo.getEquipo().getNombre());
                int valor = alfaBeta(hijo, profundidad - 1, alfa, beta, false, recorrido);
                mejorValor = Math.max(mejorValor, valor);
                alfa = Math.max(alfa, mejorValor);
                if (beta <= alfa) {
                    recorrido.add("Poda en " + hijo.getEquipo().getNombre());
                    break;
                }
            }
            return mejorValor;
        } else {
            int mejorValor = Integer.MAX_VALUE;
            for (NodoEquipo hijo : nodo.obtenerHijos()) {
                recorrido.add(nodo.getEquipo().getNombre() + " -> " + hijo.getEquipo().getNombre());
                int valor = alfaBeta(hijo, profundidad - 1, alfa, beta, true, recorrido);
                mejorValor = Math.min(mejorValor, valor);
                beta = Math.min(beta, mejorValor);
                if (beta <= alfa) {
                    recorrido.add("Poda en " + hijo.getEquipo().getNombre());
                    break;
                }
            }
            return mejorValor;
        }
    }
}
