package romanovich.geek.lesson1;

import java.util.List;

public class SelectionSort {
    public static List<NoteBook> sort(List<NoteBook> notebooks) {
        int min = 0;
        for (int i = 0; i < notebooks.size() - 1; i++) {
            min = i;

            for (int j = i + 1; j < notebooks.size(); j++) {
                if (notebooks.get(j).compareTo(notebooks.get(min)) < 0) {
                    min = j;
                }
            }
            if (i == min) {
                continue;
            }
            NoteBook temp = notebooks.get(i);
            notebooks.set(i, notebooks.get(min));
            notebooks.set(min, temp);
        }

        return notebooks;
    }
}
