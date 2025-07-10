package TP3_Arboles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree<T> {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public int getRoot(){
        if(this.root.getValue()!=null)
            return this.root.getValue();
        return 0;
    }

    public boolean hasElement(int value){
        if(root != null && this.root.getValue() == value){
            return true;
        }
        TreeNode aux = root;

        while (aux.getRight() != null || aux.getLeft()!= null){
            if(aux.getValue() < value){
                if(aux.getRight().getValue() == value)
                    return true;
                if(aux.getRight() == null)
                    break;
                aux = aux.getRight();
            } else if(aux.getValue() > value){
                if(aux.getLeft().getValue() == value)
                    return true;
                if(aux.getLeft() == null)
                    break;
                aux = aux.getLeft();
            }
        }
        return false;
    }

//    public List<TreeNode> getLongestBranch(){
//        /*if(isEmpty()){
//
//        }*/
//        ArrayList<TreeNode>
//    }



    public void imprimirPos(){
        imprimirPosOrden(this.root);
    }

    private void imprimirPosOrden(TreeNode nodo)
    {
        if (nodo == null)
            return;
        if(nodo.getLeft() == null && nodo.getRight()== null){
            return;
        }
        imprimirPosOrden(nodo.getLeft());
        imprimirPosOrden(nodo.getRight());
        System.out.print(nodo.getValue() + " ");
    }

/*
    Ejercicio 2
    Escriba en JAVA el código del método de la clase Tree (que representa arboles binarios)
    que tiene la siguiente declaración:
          private Lista<T> obtenerNivel (TreeNode<T> n, int k)
    El método al ser invocado con el nodo raiz del árbol binario, debe retornar una lista
    con los elementos del nivel k de dicho árbol en orden do derecha a izquierda.
    Si k es mayor a la altura del árbol deberá retornar una lista vacia.
    Suponga que la clase Lista (simplemente vinculada) y TreeNode (nodo de árbol binario) tienen los métodos usualos
    Por ejemplo para el árbol de la derecha, y k=2, debe retornar la lista <O,S,N,L>
*/



    private List<T> obtenerNivel (TreeNode<T> node, int k){
        List<T> solucion = new LinkedList<>();
        obtenerNivelRec(node,k,solucion);
        return solucion;
    }

    private void obtenerNivelRec(TreeNode<T> node, int k, List<T> solucion) {
        if (node == null)
            return;
        if(k==0)
            solucion.add((T) node.getValue());

        obtenerNivelRec(node.getRight(),k-1,solucion);
        obtenerNivelRec(node.getLeft(),k-1,solucion);
    }
}
