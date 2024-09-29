package Actividad3;
import java.util.*;

public class SeleccionProyectosGreedy 
{
        static class Proyecto 
        {
            int costo;
            int beneficio;
    
            public Proyecto(int costo, int beneficio) 
            {
                this.costo = costo;
                this.beneficio = beneficio;
            }
    
            @Override
            public String toString() 
            {
                return "costo: " + costo + "beneficio: " + beneficio;
            }
        }
        
        public static int optimizarPresupuesto(int[] costos, int[] beneficios, int presupuesto) 
        {
            Proyecto[] proyectos = new Proyecto[costos.length];
            
            for (int i = 0; i < costos.length; i++) 
            {
                proyectos[i] = new Proyecto(costos[i], beneficios[i]);
            }

            Arrays.sort(proyectos, (a, b) -> Double.compare(b.beneficio, a.beneficio));

            int beneficioTotal = 0;
            int costoTotal = 0;
    
            for (Proyecto proyecto : proyectos) 
            {
                if (costoTotal + proyecto.costo <= presupuesto) 
                {
                    costoTotal += proyecto.costo;
                    beneficioTotal += proyecto.beneficio;
                }
            }
            return beneficioTotal;
        }
        

        public static void main(String[] args) 
        {

            int[] costos = {10, 15, 20, 25};
            int[] beneficios = {100, 200, 150, 300};
            int presupuesto = 40;

            int beneficiosMaximo = optimizarPresupuesto(costos, beneficios, presupuesto);
    

            System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + beneficiosMaximo);
        }
    

}
