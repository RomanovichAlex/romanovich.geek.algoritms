package lesson4;


import java.util.Iterator;

public class DualLinkedListImpl<E> implements DualLinkedList<E>, Iterable<E> {
    protected int size;
    protected Node<E> firstNode = null;
    protected Node<E> lastNode = null;

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element, null, null);
        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
        } else if (size == 1) {
            newNode.nextNode = firstNode;
            firstNode.previousNode = newNode;
            lastNode = firstNode;
            firstNode = newNode;

        } else {
            newNode.nextNode = firstNode;
            firstNode.previousNode = newNode;
            firstNode = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null, null);
        if (size > 1) {
            newNode.previousNode = lastNode;
            lastNode.nextNode = newNode;
            lastNode = newNode;
        } else {
            newNode.previousNode = lastNode;
            lastNode.nextNode = newNode;
            firstNode = lastNode;
            lastNode = newNode;
        }
        size++;
    }

    @Override
    public boolean set(int index, E element) {
        if (size != 0 && size > index) {
            int i = 0;
            Node<E> searchedNode = firstNode;
            while (i <= index) {
                if (i == index) {
                    searchedNode.value = element;
                    return true;
                }
                searchedNode = searchedNode.nextNode;
                i++;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        if (size != 0) {
            Node<E> searchedNode = firstNode;
            do {
                if (searchedNode.value.equals(element)) {
                    return true;
                }
                searchedNode = searchedNode.nextNode;
            }
            while (searchedNode.nextNode != null);
        }
        return false;
    }

    @Override
    public boolean remove(E element) {
        if (size != 0) {
            Node<E> searchedNode = firstNode;
            Node<E> searchedPreviousNode = firstNode;
            do {
                if (searchedNode.value.equals(element)) {
                    searchedPreviousNode.nextNode = searchedNode.nextNode;
                    searchedNode.nextNode.previousNode = searchedPreviousNode;
                    size--;
                    return true;
                }
                searchedPreviousNode = searchedNode;
                searchedNode = searchedNode.nextNode;
            } while (searchedNode.nextNode != null);
        }
        return false;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (size != 0) {
            Node<E> searchedNode = firstNode;
            do {
                if (searchedNode.value.equals(element)) {
                    return index;
                }
                searchedNode = searchedNode.nextNode;
                index++;
            }
            while (searchedNode.nextNode != null);
        }
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if (size != 0) {
            firstNode = null;
            lastNode = null;
            size = 0;
        }
    }

    @Override
    public E peekFirst() {
        return size != 0 ? firstNode.value : null;
    }

    @Override
    public E peekLast() {
        return size != 0 ? lastNode.value : null;
    }

    @Override
    public void display() {
        StringBuilder str = new StringBuilder("LinkedList = [");
        Node<E> current = firstNode;
        while (current != null) {
            str.append(current.value);

            current = current.nextNode;
            if (current != null) {
                str.append(" <> ");
            }
        }
        str.append("]");
        System.out.println(str);

    }

    @Override
    public Iterator<E> iterator() {
        return new DualLinkedListIterator<>(firstNode);
    }

    private class DualLinkedListIterator<E> implements Iterator<E> {
        Node<E> current;
        public DualLinkedListIterator(Node<E> firstNode) {
            this.current = firstNode;
        }
        @Override
        public boolean hasNext() {
            if (firstNode == null || current == lastNode.nextNode) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public E next() {
            E val = current.value;
            current = current.nextNode;
            return val;
        }
    }
}
