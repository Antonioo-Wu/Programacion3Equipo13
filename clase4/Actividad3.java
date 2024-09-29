/*
 * ### Actividad 3

Una empresa distribuidora necesita cargar un camión con 
mercancía que se puede fraccionar. Indicar con una lista 
los elementos a subir al camión para maximizar el valor total, 
dado que el camión tiene una capacidad limitada. 
 */


import java.util.Arrays;
public class Actividad3 {
    static class Mercancia{
        int valor;
        int peso;

        public Mercancia(int valor, int peso){
            this.valor = valor;
            this.peso = peso;
        }
    }

    public static double maximizarCapacidad(Mercancia[]  mercancias, double capacidad){
        // 1. ordeno mis mercancias como siempre pero teniendo en cuenta el peso de cada una
        Arrays.sort(mercancias); // O(n log n)
        // DUDA: no se como hacerlo por peso

        double valorTotal = 0.0; // O(1) lo que voy a devolver
         
        for(Mercancia mercancia : mercancias){ // O(n log n)
            if( capacidad == 0){ // O(1) . termina porque ya no hay más espacio
                break; 
            }

            if(mercancia.peso <= capacidad){ // O(1) . es menor o igual que el peso = puedo seeguir agregando
                capacidad -= mercancia.peso; // O(1) . le resto a la capacidad de este camión el peso que le agrego
                valorTotal += mercancia.valor; //O(1) . le agrego al valortotal el precio de esta mercancia
            }else{
                // Hay que fraccionar porque es más grande que capacidad
                double fraccionada = capacidad / mercancia.peso; // O(1) . a la capacidad del camion le divido el peso de la mercancia para ver cuanto pueod meter
                valorTotal += mercancia.valor * fraccionada; // O(1) . no puedo sumarle el valor total, sino una pare de el
                capacidad = 0; // O(1) . el camión esta lleno
            }

        }
        return valorTotal;

    }
    public static void main(String[] args) {
         Mercancia[] misMercancias = {
            //TENGO EL MISMO ERROR QUE CLASE 3 ACT 3 :(
            new Mercancia(2000, 10),
            new Mercancia(1500, 30),
            new Mercancia(3000, 40)
        };

        double capacidadPerCamion = 50; 
        
        double valorMax = maximizarCapacidad(misMercancias,capacidadPerCamion);
        System.out.println("La capcidad máxima que puede llevar el camión es de : "+ capacidadPerCamion);
        System.out.println("Por lo tanto, el valor máximo será de : $"+ valorMax + " .");
    }
}
