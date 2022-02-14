package lesson6;

import java.util.Stack;

//реализуем интерфейс трее
public class TreeImpl<E extends Comparable<? super E>> implements lesson6.Tree<E> {

    //поле корневогоузла дерева
    protected Node<E> root;
    //размер дерева
    protected int size;

    //
    private class NodeAndParent {
        //узел
        private Node<E> current;
        //узел
        private Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    @Override
    public boolean contains(E value) {
        //возращается nodeAndParent
        NodeAndParent nodeAndParent = doFind(value);
        //если не найден
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind(E value) {
        //корень
        Node<E> current = root;
        //родитель
        Node<E> parent = null;

        //пока карент не равен нулл
        while (current != null) {
            //нашли ли мы наш элемент и не равен ли он искомому
            if (current.getValue().equals(value)) {
                //возращаем новый экземпляр и парент и каррент
                return new NodeAndParent(current, parent);
            }

            //корень равен текущему карренту
            parent = current;
            //методом сомпаре сравниваем
            if (current.isLeftChild(value)) {
                //приравниваем
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
//имя родителя и нулл где этот элемент должен быть при добавлении
        return new NodeAndParent(null, parent);
    }


    //добавление
    @Override
    public boolean add(E value) {
        //ищем позицию где элемент будет существовать в дереве
        NodeAndParent nodeAndParent = doFind(value);
//сравниваем
        if (nodeAndParent.current != null) {
            //счетчик
            //nodeAndp.current.incRepeat();
            return false;
        }

        //узел
        Node<E> parent = nodeAndParent.parent;
        //новый узел в который передается значение
        Node<E> node = new Node<>(value);
//если узел корневой то добавляем в корень
        if (isEmpty()) {
            root = node;
            //если значение должно быть слева
        } else if (parent.isLeftChild(value)) {
            parent.setLeftChild(node);
            //если значение должно быть справа
        } else {
            parent.setRightChild(node);
        }
//увеличиваем размер дерева
        size++;

        return true;
    }


    //удаление
    @Override
    public boolean remove(E value) {
        //находим узел для удаления
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removed = nodeAndParent.current;

        //если узла нет
        if (removed == null) {
            return false;
        }

        //если узел лист от дерева
        if (removed.isLeaf()) {
            //передаем удаляемый узел и родитель
            removeLeafNode(removed, parent);
            //если у узла один дочерний элемент
        } else if (removed.hasOnlyOneChild()) {
            //в метод отправляем удаляемый узел и его родитель
            removeNodeWithOneChild(removed, parent);
        } else {
            //удаление когда два дочерних узла ссылка на ремувт и узел
            //[1, 2, 3, 4, 5]  [7 8 9 10 11]
            removedNodeWithAllChildren(removed, parent);
        }


        size--;
        return true;
    }


    //удаление
    private void removeLeafNode(Node<E> removed, Node<E> parent) {
        //если узел корень
        if (removed == root) {
            root = null;
            //если левый узел
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(null);
        } else {
            //если правый
            parent.setRightChild(null);
        }
    }

//
    private void removeNodeWithOneChild(Node<E> removed, Node<E> parent) {
        Node<E> child = removed.getLeftChild() != null ? removed.getLeftChild() : removed.getRightChild();

        if (removed == root) {
            root = null;
//если левый узел не отсутствует забираем левый
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(child);
            //правый
        } else {
            parent.setRightChild(child);
        }
    }


    //удаление при двух узлах
    private void removedNodeWithAllChildren(Node<E> removed, Node<E> parent) {
        //метод ищет приемника, и передаем ему удаляемый узел
        Node<E> successor = getSuccessor(removed);

        if (removed == root) {
            root = successor;
        } else if (parent.isLeftChild(removed.getValue())) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }
    }

    //ищем
    private Node<E> getSuccessor(Node<E> removed) {
        Node<E> successor = removed;
        Node<E> parent = null;
        Node<E> current = removed.getRightChild();

        //позволяет спускаться ниже
        while (current != null) {
            parent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        //если
        if (successor != removed.getRightChild() && parent != null) {
            parent.setLeftChild(successor.getRightChild());
            //присваеваем правый дочерний элемент
            successor.setRightChild(removed.getRightChild());
        }
        //сохраняем левый дочерний
        successor.setLeftChild(removed.getLeftChild());
//возращаем соцесор
        return successor;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


    //обходы
    @Override
    public void traverse(TraversMode mode) {
        //выбираем обход исходим от корня
        switch (mode) {
            case PRE_ORDER: preOrder(root); //прямой
            case IN_ORDER: inOrder(root); //центированный
            case POST_ORDER: postOrder(root); //обратный
        }
        System.out.println();
    }



    //прямой
    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.print(current.getValue() + " ");
        //движемся в левое под дерево
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");
    }

public boolean balance() {return isBalanced(root);}

    public boolean isBalanced(Node<E> node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }
}
