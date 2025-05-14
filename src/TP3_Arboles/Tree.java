package TP3_Arboles;

import java.util.ArrayList;

public class Tree {

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
}
