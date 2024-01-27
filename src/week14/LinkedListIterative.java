package src.week14;

public class LinkedListIterative <T>{
    Node<T> head = null;

    int count = 0;

    LinkedListIterative() {}

    public void add(T data) {
        if(head == null) {
            head = new Node<T>(data, null);
            return;
        }

        Node<T> current = head;

        while(current.next != null) {
            current = current.next;
        }

        count += 1;

        current.next = new Node<T>(data, null);
    }

    public void remove(T data) {
        if(head.data == data) {
            head = head.next;
        }

        Node<T> parent = head;
        Node<T> current = head.next;

        while(current != null && current.data != data) {
            parent = current;
            current = current.next;
        }

        // check if we are trying to remove an item not in the list
        if(current == null) {
            return;
        }

        parent.next = current.next;
        count -= 1;

    }

}
