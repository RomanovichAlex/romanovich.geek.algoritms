package lesson8;


public class Main {

    public static void main(String[] args) {
        HashTable<Object,Object> hashTable = new HashTableImplChain<>(5);

        hashTable.put(new Product(1, "Orange"), 150);//1
        hashTable.put(new Product(77, "Banana"), 100);//7
        hashTable.put(new Product(67, "Carrot"), 228);//7
        hashTable.put(new Product(60, "Lemon"), 250);//0
        hashTable.put(new Product(51, "Milk"), 120);//1
        hashTable.put(new Product(21, "Potato"), 67);//2
        hashTable.put(new Product(2, "Whiski"), 520);//3
        hashTable.put(new Product(22, "Coca-Cola"), 10);//3

        System.out.println("Размер: " + hashTable.size());

        hashTable.display();

        System.out.println("Whiski стоит: " + hashTable.get(new Product(2, "Whiski")));
        System.out.println("Coca-Cola стоит: " + hashTable.get(new Product(22, "Coca-Cola")));

        hashTable.remove(new Product(2, "Whiski"));
        hashTable.remove(new Product(77, "Banana"));

        hashTable.display();

        System.out.println("Whiski стоит: " + hashTable.get(new Product(2, "Whiski")));
        System.out.println("banana стоит: " + hashTable.get(new Product(77, "Banana")));
        System.out.println("carrot стоит: " + hashTable.get(new Product(67, "Carrot")));

        hashTable.put(new Product(47, "Pineapple"), 228);

        hashTable.display();

        System.out.println("Pineapple стоит: " + hashTable.get(new Product(47, "Pineapple")));
    }
}
