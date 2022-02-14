package lesson4;

public interface DualLinkedList<E> extends Iterable<E> {

    void addFirst(E element);

    void addLast(E element);

    int indexOf(E element);

    boolean set(int index, E element);

    boolean remove(E element);

    boolean contains(E element);

    int size();

    void clear();

    E peekFirst();

    E peekLast();

    void display();


    class Node<E> {
        E value;
        Node<E> nextNode;
        Node<E> previousNode;

        public Node(E value, Node<E> nextNode, Node<E> previousNode) {
            this.value = value;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }


        public Node() {
            this.value = null;
            this.nextNode = new Node<>();
            this.previousNode = new Node<>();
        }

        public void display() {
            System.out.println("Value: " + this.value + " ");
        }

    }

}
