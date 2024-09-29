package Progra3.clase1;

public class Actividad3 {
    public static int sumaRecursiva(int n){
        if(n == 0){  // caso base -> complejidad O(1)
            return 0; //  O(1)
        } else{ // llamada recursiva -> complejidad O(1)
            return n + sumaRecursiva(n -1); // n -> se va a realziar en relación al valor de n O(n)
        }
    } // Complejidad total : O(n)

    public static void main(String[] args) {
        int num = 10;
        int resultado = sumaRecursiva(num);
        System.out.println("La suma de los primeros " + num + " números enteros es " + resultado);
    }
    
}
