package lesson6;

//Comparable интерфейс который несет метод сomparеТо
public interface Tree<E extends Comparable<? super E>> {

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER;
    }
    //проверка на наличие

    boolean contains(E value);
    //добавление элемента

    boolean add(E value);
    //удаление
    boolean remove(E value);
    //проверка на пустоту
    boolean isEmpty();
    //размер
    int size();
//метод вывода на экран

    void display();

    void traverse(TraversMode mode);

}
