import java.util.Scanner;

/**
 * Проверка на простоту
 * Вам доверяется важная миссия проверки чисел на простоту. Не подведите галлактику!
 *
 * Входные данные
 * На вход подаётся одно число N (2 ≤ N ≤ 10^9).
 *
 * Выходные данные
 * Выведите True, если число воистину простое, и False, если число составное.
 */
public class Task3917 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}