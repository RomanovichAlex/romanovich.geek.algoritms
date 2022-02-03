package lesson4;

public class lesson4 {


        public static void main(String[] args) {

            DualLinkedListImpl<Integer> list = new DualLinkedListImpl<Integer>();
            list.addFirst(8);
            list.addFirst(3);
            list.addFirst(0);
            list.addFirst(4);
            list.addLast(70);
            list.addLast(60);
            list.addLast(52);

            list.display();

            System.out.println("Заменить значение под индексом 1 на 1:" + list.set(1, 1));
            System.out.println("Значение первого: " + list.peekFirst());
            System.out.println("Есть ли в списке 4: " + list.contains(4));
            System.out.println("Значение последнего: " + list.peekLast());
            System.out.println("Индекс элемента со значением 60:" + list.indexOf(60));
            System.out.println(list.size());
            list.display();

            System.out.println("Удалили 8 из списка: " + list.remove(8));
            System.out.println("Удалили 60 из списка: " + list.remove(60));
            System.out.println(list.size());
            list.display();


            System.out.println("Вывели на экран список через цикл foreach:");
            for (Integer node : list
            ) {
                System.out.print(node + "  ");
            }
            System.out.println();
            System.out.println("Очистили список");
            list.clear();
            list.display();
        }
    }
