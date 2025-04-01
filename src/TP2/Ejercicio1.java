package TP2;

import java.util.ArrayList;

public class Ejercicio1 {
    private int size;


    public boolean inOrder(ArrayList<Integer> arr, int index){
        int aux = arr.get(index);
        boolean ordenado = false;
        this.size = arr.size() - 1;
        if(aux < arr.get(index+1) && index < size){
            ordenado = true;
            if(arr.get(index + 1)!= null){
                return ordenado;
            }
            inOrder(arr, aux +1);
        }
        return ordenado;
    }
}
