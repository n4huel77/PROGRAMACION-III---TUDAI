package TP1_Listas;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public void insertarOrdenado(T info) {
        Node<T> newNode = new Node<>(info, null);

        // Caso 1: Lista vacia o el nuevo nodo es menor que el primero
        if (first == null || info.compareTo(first.getInfo()) == 0) { //Si compareTo devuelve 0, significa que ambos valores son iguales.
            this.insertFront(newNode.getInfo());
        }
        else {
            Node<T> aux = this.first;
            // si no se quedo sin numeros y el siguiente es < a info
            //mientras aux no sea el último nodo de la lista.
            //Compara info con el valor del siguiente nodo (aux.getNext().getInfo()).
            // Si compareTo devuelve un número negativo (< 0), significa que info es menor que el valor del siguiente nodo,
            while (aux.getNext() != null && info.compareTo(aux.getInfo())< 0) {
                aux = aux.getNext();
            }
            if (aux.getNext() == null) { // si no hay proximo inserto ultimo al next aux
                aux.setNext(newNode);
            } else { // aux es < info
                // al 4 le seteo el 5 como next, al 3 le seteo como proximo el 4
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
            }
        }
    }


    public T extractFront() {
        if(this.first == null)
            return null;
        T tmp = this.first.getInfo();
        this.first = this.first.getNext();
        this.size--;
        return tmp;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        Node<T> tmp = this.first;
        for(int i = 0; i < index; i++) {
            if(tmp != null)
                tmp = tmp.getNext();
        }
        return tmp.getInfo();
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
       Node<T> tmp = this.first;
       String str = "";
       for (int i = 0; i < this.size(); i++) {
           if(tmp != null) {
               str += tmp.getInfo();
               if(tmp.getNext() != null)
                   str += ", ";
               tmp = tmp.getNext();
           }
       }
        return str;
    }

    public int indexOf(T info) {
        Node<T> tmp = this.first;
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if(tmp != null && !tmp.getInfo().equals(info)) {
                tmp = tmp.getNext();
                index++;
            }
        }
            if(tmp == null)
                return -1;
            else
                return index;
    }


    public MySimpleLinkedList<T> getComunesListDesordenada(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {

        MySimpleLinkedList<T> retorno = new MySimpleLinkedList<>();

        MyIterator<T> it1 = new MyIterator<>(list1.getFirst());

        while(it1.hasNext()) {
            T info1 = it1.next();
            MyIterator<T> it2 = new MyIterator<>(list2.getFirst());
            while ( it2.hasNext()) {
                T info2 = it2.next();
                if (info1.equals(info2)) {
                    retorno.insertarOrdenado(info1);
                    break;
                }
            }
        }
        return retorno;
        }

    public MySimpleLinkedList<T> getComunesListOrdenados(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
        MySimpleLinkedList<T> retorno = new MySimpleLinkedList<>();

        MyIterator<T> it1 = new MyIterator<>(list1.getFirst());
        while (it1.hasNext()){
            T info1 = it1.next();
            MyIterator<T> it2 = new MyIterator<>(list2.getFirst());
            while (it2.hasNext()){
                T info2 = it2.next();
                if(info1.equals(info2)){
                    retorno.insertarOrdenado(info1);
                    break;
                }
                if(info1.compareTo(info2)<0) {//SI ES MAS CHICO CORTO LA BUSQUEDA
                    break;
                }

            }
        }
        return null;
    }

    public static <T extends Comparable<T>> MySimpleLinkedList<T> getListUnique(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2){
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();
        Iterator<T> it = l1.iterator();
        boolean encontrado;

        while (it.hasNext()){
            Iterator<T> it2 = l2.iterator();
            T aux1 = it.next();
            encontrado = false;
            while (it2.hasNext()) {
                T aux2 = it2.next();
                if (aux1.equals(aux2)) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado){
                result.insertFront(aux1);
            }
        }
        return result;
    }

    private Node<T> getFirst() {
        return this.first;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyIterator<>(this.first);
    }


}
