package lesson8;

public class HashTableImplChain<K, V> implements HashTable<K, V> {
    //создаем массив состоящий из экземпляров
    private final Item<K, V>[] data;
    //размер
    private int size;


    //класс который хранит все карточки
    static class Item<K, V> implements Entry<K, V> {
        //объявляем переменную для ключа
        private final K key;
        //объявляем переменную для значения
        private V value;
        private Item<K, V> next;

        // в конструкторе принимаем оба значения
        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        //реализуем геттеры
        public Item<K, V> getNext() {
            return next;
        }
        public void setNext(Item<K, V> next) {
            this.next = next;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        //для вывода
        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    //создаем конструктор хэш табл в которой храним
    public HashTableImplChain(int initialCapacity) {
        //data массив с размером initialCapacity * 2
        data = new Item[initialCapacity * 2];
    }

    //перегруженный конструктор с дефолтным значением
    public HashTableImplChain() {
        this(16);
    }

    //добавляет
    @Override
    //принимает два аргумента ключ-значение
    public boolean put(K key, V value) {
        //есть ли место что бы добавить новый аргумент
        if (size() == data.length) {
            return false;
        }
        //если место есть определяем индекс, ключа по хэш функции
        int index = hashFunc(key);
        if (data[index] == null) {
            data[index] = new Item<>(key, value);
            size++;
        }else {
            Item<K, V> item = data[index];
            while (item.getNext() != null && !item.getKey().equals(key)) {
                item = item.getNext();
            }
            if (item.getKey().equals(key)){
                item.setValue(value);
            }else {
                item.setNext(new Item<>(key, value));
                size++;
            }
        }
        return true;
    }

    //хэш функция
    private int hashFunc(K key) {
        //по модулю получаем ключ, хэш функция нахождения позиции в массиве
        return Math.abs(key.hashCode() % data.length);
    }




    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        Item<K, V> item = getItemKey(key);
        return item == null ? null : item.value;
    }

    private Item<K, V> getItemKey(K key) {
        int index = hashFunc(key);
        Item<K, V> current = data[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    //удаеление
    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        if (data[index] != null) {
            Item<K, V> previousItem = null;
            Item<K, V> item = data[index];
            while (item.getNext() != null && !item.getKey().equals(key)) {
                previousItem = item;
                item = item.getNext();
            }
            if (item.getKey().equals(key)) {
                if (previousItem == null) {
                    data[index] = item.getNext();
                    size--;
                }else {
                    previousItem.setNext(item.getNext());
                }
            }
            return item.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item<K, V> i : data) {
            sb.append("{");
            if (i != null) {
                Item<K, V> item = i;
                do {
                    sb.append(item.getValue()).append(", ");
                    item = item.getNext();
                } while (item != null);
            }
            sb.append("} ");
            sb.append("\n");
        }
        return sb.toString();
    }
}