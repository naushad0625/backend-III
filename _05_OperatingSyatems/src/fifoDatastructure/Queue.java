package fifoDatastructure;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        this.head = this.tail = null;
    }

    public void push(T data) {
        Node<T> node  = new Node<>(data);
        if(head == null) {
            head = tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
    }

    public T pull () {
        if(tail == null){
            System.out.println("Queue is empty");
            System.exit(0);
        }

        T data = tail.getData();
        tail = tail.getPrev();

        if(tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        return data;
    }
}
