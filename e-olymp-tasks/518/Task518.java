import java.io.PrintWriter;
import java.util.*;

/**
 * Сумма двух
 * Найти сумму двух чисел.
 *
 * Входные данные
 * Первая строка содержит количество тестов t (1 ≤ t ≤ 100). Каждый тест состоит из двух 16-битных целых чисел a и b.
 *
 * Выходные данные
 * Для каждого теста вывести в отдельной строке сумму чисел a и b.
 */
public class Task518 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = in.nextInt();

        for (int i = 0; i < num; i++) out.println(in.nextInt() + in.nextInt());

        out.flush();
    }
}