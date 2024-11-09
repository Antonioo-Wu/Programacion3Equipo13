package com.F1.controller;

import com.F1.model.Corredor;
import com.F1.model.Equipo;
import com.F1.service.F1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/f1")
public class F1Controller {
    
    @Autowired
    private F1Service f1Service;
    
    @PutMapping("/equipo")
    public Equipo createEquipo(@RequestBody Equipo equipo, @RequestParam Long rivalId) {
        return f1Service.saveEquipo(equipo, rivalId);
    }
    
    @PutMapping("/corredor")
    public Corredor createCorredor(@RequestBody Corredor corredor) {
        return f1Service.saveCorredor(corredor);
    }
    
    @GetMapping("/dfs/{equipoId}")
    public List<String> dfsRecorrido(@PathVariable Long equipoId) {
        return f1Service.dfsRecorrido(equipoId);
    }
    
    @GetMapping("/bfs/{equipoId}")
    public List<String> bfsRecorrido(@PathVariable Long equipoId) {
        return f1Service.bfsRecorrido(equipoId);
    }
    
    @GetMapping("/backtracking/{equipoId}")
    public List<String> backtrackingRecorrido(@PathVariable Long equipoId) {
        return f1Service.backtrackingRecorrido(equipoId);
    }
    
    @GetMapping("/poda-alfa-beta/{equipoId}")
    public List<String> podaAlfaBetaRecorrido(@PathVariable Long equipoId) {
        return f1Service.podaAlfaBetaRecorrido(equipoId);
    }
    
    

    
    @GetMapping("/equipos")
    public List<Equipo> getAllEquipos() {
        return f1Service.getAllEquipos();
    }
    
    
}
