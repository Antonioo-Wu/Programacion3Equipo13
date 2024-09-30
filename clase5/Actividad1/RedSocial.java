package Actividad1;

import java.util.*;

public class RedSocial {
    static class usuario {
        int id;
        String nombre;

        usuario(int id, String nombre){
            this.id = id;
            this.nombre = nombre;
        }

        @Override
        public String toString(){
            return "id: " + this.id + " nombre: " + this.nombre;
        }
    }

    static class redSocial{
        // La clave es un objeto usuario y el valor es una 
        // lista de objetos usuario que representan a los usuarios seguidos por el usuario clave.
        private Map<usuario, List<usuario>> matriz;

        public redSocial(){
            this.matriz = new HashMap<>();
        }

        // Complejidad: O(1) en promedio
        public void agregarUsuario(usuario u){
            matriz.putIfAbsent(u, new ArrayList<>());
        }

        // Complejidad: O(n) en el peor caso
        public void seguir(usuario seguidor, usuario seguido)
        {
            matriz.putIfAbsent(seguidor, new ArrayList<>()); // O(1) en promedio
            matriz.putIfAbsent(seguidor, new ArrayList<>()); // O(1) en promedio

            List<usuario> seguidores = matriz.get(seguidor); // O(1) en promedio
            if (!seguidores.contains(seguido)) // O(n) donde n es el número de seguidos
                seguidores.add(seguido); // O(1) en promedio
        }

        // Complejidad: O(n) en el peor caso
        public void dejarDeSeguir(usuario seguidor, usuario seguido)
        {
            List<usuario> seguidores = matriz.get(seguidor); // O(1) en promedio
            if (seguidores != null)
                seguidores.remove(seguido); // O(n) donde n es el número de seguidos
        }

        // Complejidad: O(1)
        public List<usuario> listarSeguidos(usuario u)
        {
            return matriz.get(u); // O(1)
        }

        // Complejidad: O(m * n) en el peor caso
        public List<usuario> listarSeguidores(usuario u)
        {
            List<usuario> seguidores = new ArrayList<>();
            for (usuario usuario : matriz.keySet()) // O(m) donde m es el número de usuarios
            {
                if (matriz.get(usuario).contains(u)) // O(n) donde n es el número de seguidos
                {
                    seguidores.add(usuario); // O(1) en promedio
                }
            }
            return seguidores;
        }
    }




    public static void main(String[] args) 
    {
        redSocial redSocial = new redSocial();
        
        usuario delfina = new usuario(1, "Delfina");
        usuario ignacio = new usuario(2, "Ignacio");
        usuario antonio = new usuario(3, "Antonio");

        
        redSocial.agregarUsuario(delfina);
        redSocial.agregarUsuario(ignacio);
        redSocial.agregarUsuario(antonio);

        redSocial.seguir(delfina, ignacio);
        redSocial.seguir(delfina, antonio);
        redSocial.seguir(ignacio, delfina);

        redSocial.listarSeguidores(antonio);
        redSocial.listarSeguidos(antonio);

        System.out.println("seguidores de ignacio: " + redSocial.listarSeguidos(ignacio));
        System.out.println("seguidores de delfina: " + redSocial.listarSeguidores(delfina));
        System.out.println("seguidores de antonio: " + redSocial.listarSeguidores(antonio));
        System.out.println("seguidos de delfina: " + redSocial.listarSeguidos(delfina));
        System.out.println("seguidos de ignacio: " + redSocial.listarSeguidos(ignacio));
    }
    
}
