package clase11.actividad4;

public class Main {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        // Agregar usuarios
        redSocial.agregarUsuario(1, "Delfina");
        redSocial.agregarUsuario(2, "Ignacio");
        redSocial.agregarUsuario(3, "Teo");
        redSocial.agregarUsuario(4, "Lali");
        redSocial.agregarUsuario(5, "Antonio");

        // Conectar usuarios
        redSocial.conectarUsuarios(1, 2);
        redSocial.conectarUsuarios(1, 3);
        redSocial.conectarUsuarios(2, 4);
        redSocial.conectarUsuarios(3, 5);


        // Realizar recorridos
        redSocial.DFS(1);
        redSocial.BFS(1);
    }
}