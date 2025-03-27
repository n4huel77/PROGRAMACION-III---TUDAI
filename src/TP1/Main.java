package TP1;

import javax.xml.transform.Source;

public class Main {
    public static void main(String[] args) {

        //LISTA A
        MySimpleLinkedList<Integer> listA = new MySimpleLinkedList<>();
        Node<Integer> na1 = new Node<>(-3, null);
        Node<Integer> na2 = new Node<>(7, null);
        Node<Integer> na3 = new Node<>(4, null);
        Node<Integer> na4 = new Node<>(0, null);
        Node<Integer> na5 = new Node<>(10, null);
        Node<Integer> na6 = new Node<>(1, null);
        Node<Integer> na7 = new Node<>(2, null);
        Node<Integer> na8 = new Node<>(4, null);
        Node<Integer> na9 = new Node<>(3, null);

        listA.insertFront(na1.getInfo());
        listA.insertFront(na2.getInfo());
        listA.insertFront(na3.getInfo());
        listA.insertFront(na4.getInfo());
        listA.insertFront(na5.getInfo());

        System.out.println(listA.get(1));
        listA.insertarOrdenado(na6.getInfo());
        listA.insertarOrdenado(na7.getInfo());
        listA.insertarOrdenado(na8.getInfo());
        listA.insertarOrdenado(na9.getInfo());

        // LISTA B
        MySimpleLinkedList<Integer> listB = new MySimpleLinkedList<>();
        Node<Integer> nb1 = new Node<>(3, null);
        Node<Integer> nb2 = new Node<>(7, null);
        Node<Integer> nb3 = new Node<>(4, null);
        Node<Integer> nb4 = new Node<>(10, null);

        listB.insertFront(nb1.getInfo());
        listB.insertFront(nb2.getInfo());
        listB.insertFront(nb3.getInfo());
        listB.insertFront(nb4.getInfo());

        MySimpleLinkedList<Integer> listC = new MySimpleLinkedList<>();
        System.out.println(listC.getComunesListOrdenados(listA,listB));

        MySimpleLinkedList<Integer> listD = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> listE = new MySimpleLinkedList<>();

        //Creacion de nodos para la segunda busqueda
        Node<Integer> nOrd1 = new Node<>(3, null);
        Node<Integer> nOrd2 = new Node<>(4, null);
        Node<Integer> nOrd3 = new Node<>(7, null);
        Node<Integer> nOrd4 = new Node<>(8, null);
        Node<Integer> nOrd5 = new Node<>(3, null);
        Node<Integer> nOrd6 = new Node<>(7, null);
        Node<Integer> nOrd7 = new Node<>(9, null);
        Node<Integer> nOrd8 = new Node<>(10, null);


        listD.insertarOrdenado(nOrd1.getInfo());
        listD.insertarOrdenado(nOrd2.getInfo());
        listD.insertarOrdenado(nOrd3.getInfo());
        listD.insertarOrdenado(nOrd4.getInfo());
        listE.insertarOrdenado(nOrd5.getInfo());
        listE.insertarOrdenado(nOrd6.getInfo());
        listE.insertarOrdenado(nOrd7.getInfo());
        listE.insertarOrdenado(nOrd8.getInfo());

        System.out.println(listC.getComunesListOrdenados(listD,listE));


    }
}