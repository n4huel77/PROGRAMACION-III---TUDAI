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


    public ArrayList<Integer> getBinario(int number){
        ArrayList<Integer> resultado = new ArrayList<>();

        if(number == 0 || number == 1){
            resultado.add(number);
            return resultado;
        }

        int division = number/2;
        int resto = number - (division * 2);

        number = division;
        ArrayList<Integer> list = getBinario(number);
        list.add(resto);
        return list;
    }

                            //10            1           0
    public static String fib(int contador, int actual, int prev) {
        if (contador > 0) {// Primera iteracion con 10
            return prev + " " + fib(contador - 1, actual + prev, actual);
            // retorna 0 + {(0+1)} 1  + 1  en la primera vuelta
        } else {
            return "";
        }
    }
    //Se llama en main asi
    public static void main(String[] args) {
        System.out.println(fib(10, 1, 0));
    }
}
