package com.F1.model;

import java.util.ArrayList;
import java.util.List;

public class NodoEquipo {
    private Equipo equipo;
    private int valor;
    private List<NodoEquipo> hijos;
    private List<Corredor> corredores;

    public NodoEquipo(Equipo equipo) {
        this.equipo = equipo;
        this.hijos = new ArrayList<>();
        this.corredores = new ArrayList<>();
        this.valor = calcularValor();
    }

    private int calcularValor() {
        // Calculamos el valor basado en la cantidad de rivales y corredores
        int valorRivales = equipo.getRivales().size() * 10;
        int valorCorredores = corredores.size() * 5;
        return valorRivales + valorCorredores;
    }

    public boolean esNodoTerminal() {
        return equipo.getRivales().isEmpty();
    }

    public int obtenerValor() {
        return valor;
    }

    public List<NodoEquipo> obtenerHijos() {
        if (hijos.isEmpty()) {
            for (Equipo rival : equipo.getRivales()) {
                hijos.add(new NodoEquipo(rival));
            }
        }
        return hijos;
    }

    public Equipo getEquipo() {
        return equipo;
    }
} 