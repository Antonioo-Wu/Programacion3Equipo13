package clase11.actividad4;

import java.util.*;

public class RedSocial {
    private Map<Integer, Usuario> usuarios;

    public RedSocial() {
        this.usuarios = new HashMap<>();
    }

    public void agregarUsuario(int id, String nombre) {
        if (!usuarios.containsKey(id)) {
            usuarios.put(id, new Usuario(id, nombre));
        } else {
            System.out.println("Ya existe un usuario con el ID " + id);
        }
    }

    public void conectarUsuarios(int id1, int id2) {
        Usuario usuario1 = usuarios.get(id1);
        Usuario usuario2 = usuarios.get(id2);
        if (usuario1 != null && usuario2 != null) {
            usuario1.agregarAmigo(usuario2);
        } else {
            System.out.println("Uno o ambos usuarios no existen");
        }
    }

    private void DFSUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(usuarios.get(v).getNombre() + " ");

        Usuario actual = usuarios.get(v);
        List<Integer> adyacentes = new ArrayList<>();
        for (Usuario amigo : actual.getAmigos()) {
            adyacentes.add(amigo.getId());
        }
        Collections.sort(adyacentes);

        for (int n : adyacentes) {
            if (!visitado[n]) {
                DFSUtil(n, visitado);
            }
        }
    }

    public void DFS(int inicio) {
        Usuario inicioUsuario = usuarios.get(inicio);
        if (inicioUsuario == null) {
            System.out.println("El usuario de inicio no existe");
            return;
        }

        boolean[] visitado = new boolean[10];
        System.out.println("Recorrido DFS desde " + inicioUsuario.getNombre() + ":");
        DFSUtil(inicio, visitado);
        System.out.println();
    }

    public void BFS(int idInicio) {
        Usuario inicio = usuarios.get(idInicio);
        if (inicio == null) {
            System.out.println("El usuario de inicio no existe");
            return;
        }

        boolean[] visitado = new boolean[usuarios.size() + 1]; // +1 porque los IDs empiezan en 1
        ArrayList<Usuario> cola = new ArrayList<>();

        visitado[idInicio] = true;
        cola.add(inicio);

        System.out.println("Recorrido BFS desde " + inicio.getNombre() + ":");
        while (!cola.isEmpty()) {
            Usuario actual = cola.remove(0);
            System.out.print(actual.getNombre() + " ");

            for (Usuario amigo : actual.getAmigos()) {
                if (!visitado[amigo.getId()]) {
                    visitado[amigo.getId()] = true;
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}
