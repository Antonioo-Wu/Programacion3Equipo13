package com.F1.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Objects;

@Node("Corredor")
public class Corredor {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String nombre;
    private String pais;
    
    @Relationship(type = "PERTENECE_A")
    private Equipo equipo;
    
    public Corredor() {
    }
    
    public Corredor(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corredor corredor = (Corredor) o;
        return Objects.equals(id, corredor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
