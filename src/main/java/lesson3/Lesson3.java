package lesson3;

import lesson3.search.BinarySearch;
import lesson3.search.FindingTheLostNumber;

public class Lesson3 {

    public static void main(String[] args) {

        /*1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
        Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
        Примеры:
        [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
        [1, 2, 4, 5, 6] => 3
        [] => 1*/

        int[] arr = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        int arr2[]={1, 2, 4, 5, 6};
        int arr3[]={};

        FindingTheLostNumber.search(arr);
        System.out.println("Массив: arr, Пропущенное число: "+ FindingTheLostNumber.search(arr));
        FindingTheLostNumber.search(arr2);
        System.out.println("Массив: arr2, Пропущенное число: "+ FindingTheLostNumber.search(arr2));
        FindingTheLostNumber.search(arr3);
        System.out.println("Массив: arr3, Пропущенное число: "+ FindingTheLostNumber.search(arr3));
    }


}