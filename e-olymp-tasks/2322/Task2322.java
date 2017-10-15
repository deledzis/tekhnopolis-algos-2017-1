import java.util.Scanner;

/**
 * Столбцы
 * Дана таблица N×N, заполненная целыми числами. Петр Первый считает столбец хорошим, если тот содержит число Х. Требуется для каждого столбца выяснить, является ли тот хорошим.
 *
 * Входные данные
 * В первой строке число X, не превышающее по модулю 2·10^9. Во второй строке число N (1 ≤ N ≤ 100). В следующих N строках по N целых чисел, не превышающих по модулю 2·10^9 - числа в ячейках таблицы.
 *
 * Выходные данные
 * Для каждого столбца выведите YES, если в нем есть число Х, и NO в противном случае (каждый ответ с новой строки).
 */
public class Task2322 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        byte[] checks = new byte[n];

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line);

            for (int j = 0; j < n; j++) {
                int num = lineScanner.nextInt();
                if (checks[j] == 0)
                    checks[j] = (byte) (num == x ? 1: 0);
            }
        }

        for (int i = 0; i < n; i++) {
            if (checks[i] == 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}