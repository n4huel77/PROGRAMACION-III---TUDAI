package TP1_Listas;

public class Node<T> {
    private T info;
    private Node<T> next;
    private Node<T> previus;


    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> next) {
        this.setInfo(info);
        this.setNext(next);
    }

    public Node(T info, Node<T> next, Node<T> previus) {
        this.info = info;
        this.next = next;
        this.previus = previus;
    }

    public Node<T> getPrevius() {
        return previus;
    }

    public void setPrevius(Node<T> previus) {
        this.previus = previus;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

}
