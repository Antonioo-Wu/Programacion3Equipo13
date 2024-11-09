package com.F1.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Node("Equipo")
public class Equipo {

    @Id
    private Long id;

    private String nombre;

    @Relationship(type = "ES_RIVAL_DE", direction = Direction.OUTGOING)
    private Set<Equipo> rivales = new HashSet<>();

    public Equipo() {
    }

    public Equipo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public Set<Equipo> getRivales() {
        return rivales;
    }

    public void setRivales(Set<Equipo> rivales) {
        this.rivales = rivales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(id, equipo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{id: " + id + ", nombre: '" + nombre + "'}";
    }
}
