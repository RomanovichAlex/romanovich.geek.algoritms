package lesson3.search;

public class FindingTheLostNumber {

        public static int search(int arr[]) {
            int start = 0;
            int end = arr.length - 1;

            while (start <= end) {
                int base = (start + end) / 2;
                if (arr[base] - base == 1) {
                    start = base + 1;
                } else {
                    end = base - 1;
                }
            }
            return start + 1;
        }

}
