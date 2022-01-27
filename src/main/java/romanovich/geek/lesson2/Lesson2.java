package romanovich.geek.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson2 {

    private static final int NOTEBOOKS_COUNT = 10000;

    public static void main(String[] args) {


        List<NoteBook> notebooks = generateListNotebooks();

        long timeStart = System.currentTimeMillis();

        notebooks = SelectionSort.sort(notebooks);

        long timeEnd = System.currentTimeMillis();

        displayNotebooks(notebooks);
        System.out.printf("Прошло времени: %dms", timeEnd - timeStart);

    }

    private static void displayNotebooks(List<NoteBook> list) {
        for (NoteBook n : list) {
            System.out.printf("Ноутбук:\tцена: %s,\tпамять: %s,\tпроизводитель: %s%n",
                    n.getPrice(),
                    n.getRamValue(), n.getManufacturer());
        }
    }

    private static ArrayList<NoteBook> generateListNotebooks() {
        ArrayList<NoteBook> arrayList = new ArrayList<>();
        for (int i = 0; i < NOTEBOOKS_COUNT; i++) {
            arrayList.add(createNoteBook());
        }
        return arrayList;
    }

    private static NoteBook createNoteBook() {
        Random random = new Random();
        int price = random.nextInt(31) * 50 + 500;
        int ramValue = (random.nextInt(6) + 1) * 4;
        int manufacturersCount = Manufacturer.values().length;
        Manufacturer manufacturer = Manufacturer.values()[random.nextInt(manufacturersCount)];
        return new NoteBook(price,ramValue,manufacturer);
    }


}