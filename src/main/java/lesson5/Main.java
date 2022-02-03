package lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

Task1 task1 = new Task1();
        System.out.println("Task 1:");
        int x =4 ;
        System.out.println("x = "+x);
        int n = -3;
        System.out.println("n = "+n);
        double ex = task1.Exponentiation(x, n);
        System.out.println(x+"^"+n+" = " + ex);

        System.out.println();

        System.out.println("Task 2:");
        List<Item> items = new ArrayList<>();
        items.add(new Item("Книга", 0.5, 200.5));
        items.add(new Item("Часы", 0.8, 5000.55));
        items.add(new Item("Посуда", 1.2, 1500.3));
        items.add(new Item("Ноутбук", 1.5, 20000.8));
        items.add(new Item("Монета", 0.2, 2200.7));
        items.add(new Item("Часы", 1, 5000));
        items.add(new Item("Очки", 0.2, 3000));
        items.add(new Item("Телевизор", 3, 40000));
        items.add(new Item("Чайник", 0.5, 2000));
        items.add(new Item("Приставка", 1.4, 18000));

        Backpack backpack = new Backpack(5);
        backpack.shufflingItems(items);


        System.out.println(backpack.getBestItems());
        System.out.println("Цена рюкзака: " + backpack.getBestPrice());
    }
}
