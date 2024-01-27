package src.week14;

public class LinkedListRec <T> {
    Node <T> head;
    int count = 0;

    LinkedListRec() {
        this.head = null;
    }

    // add
    public void add(T data) {
        if(head == null) {
            head = new Node<T>(data, null);

            count += 1;

            return;
        }

        recAdd(head, data);
    }

    private void recAdd(Node<T> current, T data) {
        if(current.next == null) {
            current.next = new Node<T>(data, null);

            count += 1;

            return;
        }

        recAdd(current.next, data);
    }

    // remove
    public void remove(T data) {
        head = recRemove(head, data);
    }

    private Node<T> recRemove(Node<T> current, T data) {
        if(current == null) {
            return null;
        }

        if(current.data == data) {
            count -= 1;
            return current.next;
        }

        current.next = recRemove(current.next, data);
        return current;
    }

    // insert
    public void insert(T data, int index) {
        if(index >= count || index < 0) {
            return;
        }

        head = recInsert(head, data, index,0);
    }

    private Node<T> recInsert(Node<T> current, T data, int index, int currentIndex) {
        if(currentIndex == index) {
            Node<T> newNode = new Node<>(data, current);
            count += 1;
            return  newNode;
        }

        current.next = recInsert(current.next, data, index, currentIndex + 1);
        return current;
    }

    // find // index of a value
    public int find(T data) {
        return recFind(head, data);
    }

    private int recFind(Node<T> current, T data) {
        if(current.data == data) {
            return 0;
        }

        return 1 + recFind(current.next, data);
    }

    // get // return the value at an index
    public T get(int index) {
        if(index >= count || index < 0) {
            return null;
        }

        return recGet(head, index, 0);
    }

    private T recGet(Node<T> current, int index, int currentIndex) {
        if(index == currentIndex) {
            return current.data;
        }

        return recGet(current.next, index, currentIndex + 1);
    }

}
