package Parcial14_06;


import TP1_Listas.Node;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;

    public void agregarPrincipio(Node<T> elemento){
        Node<T> nuevoNodo = new Node<T>(elemento.getInfo(), null);
        if(first == null){
            this.first = nuevoNodo;
            this.last = nuevoNodo;
        }else {
            nuevoNodo.setNext(this.first);
            this.first = nuevoNodo;
        }
    }

    public void agregarFinal(Node<T> elemento){
        Node<T> nuevoNodo =  new Node<>(elemento.getInfo(), null);
        if(first == null){
            agregarPrincipio(nuevoNodo);
        }
        this.last.setNext(nuevoNodo);
        this.last = elemento;
    }
}
