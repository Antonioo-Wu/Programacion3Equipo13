package Actividad1;

import java.util.*;


public class RedSocial 
{
    static class usuario
    {
        int id;
        String nombre;

        usuario(int id, String nombre)
        {
            this.id = id;
            this.nombre = nombre;
        }

        @Override
        public String toString()
        {
            return "id: " + this.id + " nombre: " + this.nombre;
        }
    }

    static class redSocial
    {
        private Map<usuario, List<usuario>> matriz;

        public redSocial()
        {
            this.matriz = new HashMap<>();
        }

        public void agregarUsuario(usuario u)
        {
            matriz.putIfAbsent(u, new ArrayList<>());
        }

        public void seguir(usuario seguidor, usuario seguido)
        {
            matriz.putIfAbsent(seguidor, new ArrayList<>()); //agrega los usuarios si no estan en la red social
            matriz.putIfAbsent(seguidor, new ArrayList<>());

            List<usuario> seguidores = matriz.get(seguidor);
            if (!seguidores.contains(seguido))
                seguidores.add(seguido);
        }

        public void dejarDeSeguir(usuario seguidor, usuario seguido)
        {
            List<usuario> seguidores = matriz.get(seguidor);
            if (seguidores != null)
                seguidores.remove(seguido);
        }

        public List<usuario> listarSeguidos(usuario u)
        {
            return matriz.get(u);
        }

        public List<usuario> listarSeguidores(usuario u)
        {
            List<usuario> seguidores = new ArrayList<>();
            for (usuario usuario : matriz.keySet())
            {
                if (matriz.get(usuario).contains(u))
                {
                    seguidores.add(usuario);
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
