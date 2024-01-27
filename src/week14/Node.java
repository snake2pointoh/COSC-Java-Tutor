package src.week14;

public class Node <T> {
    public T data;
    public Node<T> next;

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
