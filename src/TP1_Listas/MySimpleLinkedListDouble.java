package TP1_Listas;

public class MySimpleLinkedListDouble<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public MySimpleLinkedListDouble() {
        this.first = null;
        this.last = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null,null);
        tmp.setNext(this.first);
        if(first != null){
            first.setPrevius(tmp);
        }
        else {
            last = tmp;
            this.first = tmp;
            this.size++;
        }
    }

    public T extractFront() {
        if(this.first == null)
            return null;
        T tmp = this.first.getInfo();
        if(first == last){
            this.first = null;
            this.last = null;
        }
        this.first = this.first.getNext();
        this.first.setPrevius(null);
        this.size--;
        return tmp;
    }

    public boolean isEmpty() {
        return this.first == null || this.size == 0;
    }

    public T get(int index) {
        if(index < 0 || index >= size) return null;

        if (index == 0) return this.first.getInfo();

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

    private Node<T> getFirst() {
        return this.first;
    }


}
