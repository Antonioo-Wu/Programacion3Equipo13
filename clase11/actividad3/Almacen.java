package clase11.actividad3;
import java.util.ArrayList;

public class Almacen {
    Integer id;
    String nombre;
    ArrayList<Integer> destinos;

    public Almacen(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.destinos = new ArrayList<>();
    }
    public void agregarDestino(Integer id) {
        destinos.add(id);
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Integer> getDestinos() {
        return destinos;
    }
    public void setDestinos(ArrayList<Integer> destinos) {
        this.destinos = destinos;
    }
    @Override
    public String toString() {
        return "Almacen [id=" + id + ", nombre=" + nombre + ", destinos=" + destinos + "]";
    }    
        
}