package clase11.actividad4;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nombre;
    private List<Usuario> amigos;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.amigos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void agregarAmigo(Usuario amigo) {
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
            amigo.agregarAmigo(this);
        }
    }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "'}";
    }
}