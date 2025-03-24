package TP1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

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
//        MySimpleLinkedList<Integer> listB = new MySimpleLinkedList<>();
//        Node<Integer> nb1 = new Node<>(-3, null);
//        Node<Integer> nb2 = new Node<>(7, null);
//        Node<Integer> nb3 = new Node<>(5, null);
//        Node<Integer> nb4 = new Node<>(12, null);

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

        listA.Collec

//        listB.insertFront(nb1.getInfo());
//        listB.insertFront(nb2.getInfo());
//        listB.insertFront(nb3.getInfo());
//        listB.insertFront(nb4.getInfo());

    }
}