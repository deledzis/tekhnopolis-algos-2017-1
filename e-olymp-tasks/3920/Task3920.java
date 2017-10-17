import java.util.Scanner;

/**
 * МегаНОД
 * Задано несколько чисел. Найти самое большое число, на которое делятся все эти числа.
 *
 * Входные данные
 * В одной строке задано несколько чисел (1 ≤ количество чисел ≤ 1000, 1≤ каждое число ≤ 10^9).
 *
 * Выходные данные
 * Выведите наибольшее число, на которое делятся все заданные числа.
 */
public class Task3920 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = in.nextInt();

        while(in.hasNextInt()) result = gcd(result, in.nextInt());
        System.out.println(result);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}