package Actividad3;

public class SeleccionProyectosFuerzaBruta 
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

        public int getCosto()
        {
            return costo;
        }

        public int getBeneficio()
        {
            return beneficio;
        }

        @Override
        public String toString() 
        {
            return "costo: " + costo + "beneficio: " + beneficio;
        }
    }

    static class Resultado 
    {
        int beneficioMaximo;
        int costoTotal;

        public int getBeneficioMaximo()
        {
            return beneficioMaximo;
        }

        public Resultado(int beneficioMaximo, int costoTotal) 
        {
            this.beneficioMaximo = beneficioMaximo;
            this.costoTotal = costoTotal;
        }
    }

    // Función para encontrar la mejor combinación
    static Resultado mejorCombinacion(Proyecto[] proyectos, int presupuesto) {
        int n = proyectos.length;
        int mejorBeneficio = 0;
        int mejorCosto = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) 
        {  // "1 << n" es 2^n
            int costoTotal = 0;
            int beneficioTotal = 0;

            // Recorremos cada bit de la combinación actual
            for (int j = 0; j < n; j++) 
            {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    costoTotal += proyectos[j].costo;
                    beneficioTotal += proyectos[j].beneficio;
                }
            }

            // Verificar si el costo total no excede el presupuesto y si el rendimiento es mejor
            if (costoTotal <= presupuesto && beneficioTotal > mejorBeneficio) {
                mejorBeneficio = beneficioTotal;
                mejorCosto = costoTotal;
            }
        }

        // Retornar el mejor resultado
        return new Resultado(mejorBeneficio, mejorCosto);
    }
    public static void main(String[] args) 
    {
        Proyecto [] proyectos = 
        {
            new Proyecto(10, 100),
            new Proyecto(15, 200),
            new Proyecto(20, 150),
            new Proyecto(25, 300)
        };
        int presupuesto = 40;

        Resultado resultado = mejorCombinacion(proyectos, presupuesto);

        System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + resultado.getBeneficioMaximo());
    }
    
}
