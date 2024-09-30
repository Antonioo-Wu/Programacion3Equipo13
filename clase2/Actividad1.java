package Progra3.clase2;
/*
 *      10
       /  \
      5    20
     / \   / \
    3   7 15  25
                \
                 30 
    Altura de mi arbol : 3

 */

class TreeNode{
    int valor;
    TreeNode izq, der;
    public TreeNode(int valor){
        this.valor = valor;
        izq = der = null; // ambos nodos como null ya que puede ser una raíz 
    }
}

public class Actividad1 {
    // Método para calcular altura en un BST
    public static int getHeight(TreeNode raiz){
        if(raiz ==null){ // caso base -> mi árbol esta vacío
            return -1; // sería vacío el árbol entonces su altura sería -1
        }
        // caso recursivo : calculamos la altura del subárbol izq y der
        int izqPeso = getHeight(raiz.izq); 
        int derPeso = getHeight(raiz.der);
        /*MÉTODO PRINCIPAL:
         * Devuelve la altura del árbol, que es el mayor valor entre las alturas
        del subárbol izquierdo y derecho, más 1 (por el nodo actual)
         */
        return 1 + Math.max(izqPeso, derPeso);

    }

    public static void main(String[] args) {
    
        // Creo mi árbol
        TreeNode raiZ = new TreeNode(10);
        raiZ.izq = new TreeNode(5);
        raiZ.der = new TreeNode(20);

        // izq 
        raiZ.izq.izq = new TreeNode(3);
        raiZ.izq.der = new TreeNode(7);

        // der
        raiZ.der.izq = new TreeNode(15);
        raiZ.der.der = new TreeNode(25);
        raiZ.der.der.der = new TreeNode(30);


        int altura = getHeight(raiZ);
        System.out.println("Altura del árbol: " + altura);
    }
     
}
