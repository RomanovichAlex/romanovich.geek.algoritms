package lesson6;

public class Node<T extends  Comparable<? super T>> {
    //значение узла
    private T value;
//левый узел
    private Node<T> leftChild;
    private Node<T> rightChild;

    private int repeat;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChild(T value) {
        return getValue().compareTo(value)  > 0;
    }

    //если и левый и правый дочерние элементы =нулл, нет дочерних элементов
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    //если у узла один дочерний элемент
    public boolean hasOnlyOneChild() {
        //проверяем левый и правый узлы
//        return getRightChild() == null && getLeftChild() != null || getRightChild() != null && getLeftChild() == null;

        //второй способ с исключающей или
        return getRightChild() != null ^ getLeftChild() != null;
    }
}
