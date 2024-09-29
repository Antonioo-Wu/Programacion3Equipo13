
import java.util.Arrays;

/*
 * ### Actividad 2: Cambio de Moneda Extranjera con Múltiples Tipos de Comprobantes

Descripción del Problema:
Un sistema de tesorería tiene a disposición una variedad de comprobantes que incluyen monedas, cheques, bonos y otros documentos financieros.

Cada comprobante tiene un valor específico. El objetivo es realizar una compra de moneda extranjera minimizando el número de comprobantes utilizados.

Resolver mediante pseudocódigo e implementación java. Indicar la complejidad algorítmica.
 */
public class Actividad2 {

    public static int minimizarComprobantes(int[] comprobantes, int valorCompra){
        Arrays.sort(comprobantes); // O(n log n)
        int contadorDeComprobantes = 0; // Inicializo mi variable a retornar

        // realizo la resta del valor con los comprobantes en un ciclo for
        for(int i = comprobantes.length -1; i >= 0; i --){
            // el ciclo for lo inicializo con la cantidad de comprobantes que hay, mientras sea mayor e igual 
            // que cero para recorrelo completo y voy decreciendo en la lista, yendo de mayor hacia el menor
          while(valorCompra >= comprobantes[i]){ // O(n)
            // mientras que ese valor sea mayor o igual, vamos a seguir usando este comprobante
            // cuando sea menor que este comprobante, salimos del bucle while y volvemos al bucle for
            valorCompra -= comprobantes[i]; // O(1)
            contadorDeComprobantes++; // O(1)
            }
        }

        // si llego a 0 con el valor de la compra, siginifica que lo puedo llegar a cumplir con los comprobantes
        if(valorCompra == 0){ //O(1)
            return contadorDeComprobantes; // si puedo
        }else{ 
            return -1; // no puedo 
        }
    }

    public static void main(String[] args) {
        int[]  comprobantes = {1,5,10,50,100,200};  // no estoy segura si esto es lo que se pide pero es una variable modificable
        int valorCompra = 370; // monto a verificar

        int resultado = minimizarComprobantes(comprobantes,valorCompra);

        // variable que retorna es 'int' o -1 ---> resultado con mostrado con if
        if(resultado != -1 ){ // si es -1 
            System.out.println("El valor de la compra "+ valorCompra + " es posible de darse con la siguiente forma :");
            System.out.println(" ---> "+ resultado +" comprobantes utilizados.");
        }else{
            System.out.println("El valor de la compra " + valorCompra + " NO es posible de darse con la siguiente forma :");
            System.out.println("Comprobantes "+ comprobantes);
        }
    }
}
