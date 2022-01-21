package romanovich.geek.lesson1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {

int h=0;

        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(i * j);
                n--;
                h=h+1;
                System.out.println(h);
            }
        }

    }
}
