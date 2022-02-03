package lesson5;

import java.util.Scanner;

public class Task1 {
    public static double Exponentiation(double x, double n) {
        if (n == 0) return 1;
        if (n <= -1) {
            n = n * (-1);
            return 1 / (x * Exponentiation(x, n - 1));
        }
        return Exponentiation(x, n - 1) * x;
    }
}
